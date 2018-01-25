package oving5;

public class Partner {
	
	private String name;
	private Partner partner;
	
	public Partner(String name){
		this.name = name;
	}
	
	public void setPartner(Partner partner){
		if (partner != null){
			if(this.partner != null){
				getPartner().setPartner(null);
			}
			this.partner = partner;
			if(partner.getPartner() != this){
				partner.setPartner(this);
			}
		}
		else{
			getPartner().partner = null;
			this.partner = null;
		}
	}

	public String getName() {
		return this.name;
	}

	public Partner getPartner() {
		return this.partner;
	}
	
	@Override
	public String toString() {
		if (partner == null){
			return name + " er partner med " + partner;
		}
		return name + " er partner med " + partner.getName();
	}
	
	public static void main(String[] args) {
		Partner p1 = new Partner("Henrik");
		System.out.println(p1);
		Partner p2 = new Partner("Eirik");
		p1.setPartner(p2);
		System.out.println(p1);
		System.out.println(p2);
	}
	
	
	

}
