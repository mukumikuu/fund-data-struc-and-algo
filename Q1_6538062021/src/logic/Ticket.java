package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		/* FILL CODE */
		if ((type == 0)) {
			this.type = type;
			this.priceperstation = 30;
		} else if ((type == 1) || (type < 0) || (type > 2)) {
			this.type = 1;
			this.priceperstation = 30;
		} else if (type == 2) {
			this.type = type;
			this.priceperstation = 25;
		}
	}
	
	public void setStation(Station start,Station end) {
		/* FILL CODE */
		this.start = start;
		this.end = end;
	}
	
	public double calculatePrice() {
		/* FILL CODE */
		if (isStationValid(start,end)) {
			int no_of_stations = getStationDistance(start,end);
			double real_price = priceperstation * no_of_stations;
			
			switch(type) {
			
			case 0: // students
				if (no_of_stations > 4) {
					double discount_price = real_price * 0.8;
					return discount_price;
				} else {
					return real_price;
				}
				
			case 1: // adults
				return real_price;
				
			case 2: // elderly with no more than 6 stations
				double discount_price = real_price * 0.6;
				return discount_price;
			}
		} 
		
		return -1;
	}
	
	public String getDescription() {
		String typename;
		
		switch(type) {
		
		case 0:
			typename = "Student";
			break;
			
		case 1:
			typename = "Adult";
			break;
			
		case 2:
			if (isStationValid(start,end)) {
				typename = "Elderly";
				break;
			}
		
		default:
			typename = "Invalid";
		}
		
		return typename+" Ticket, from "+ getStart().getName() + " to " + getEnd().getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
