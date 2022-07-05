package colecciones;

public class Habitacion implements Comparable<Habitacion> {
	//Atributos
    private int id;
    private String name;
    //Constructor
    public Habitacion(String name, int id) {
        this.name = name;
        this.id = id;
    }
    //Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Habitacion arg0) {
		//return this.getId()-arg0.getId();
		return this.getName().compareTo(arg0.getName());
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}