package resources;

public enum APIResources {
	
	createEmployee("/api/v1/create"),
	getEmployee("/api/v1/employee/{id}"),
	updateEmployee("/api/v1/update/{id}"),
	deleteEmployee("/api/v1/delete/{id}");
	
private String resource;
	
	APIResources(String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

}
