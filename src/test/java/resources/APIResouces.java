package resources;

public enum APIResouces {
    AddPlaceAPI("/maps/api/place/add/json"),
    DeleteplaceAPI("/maps/api/place/delete/json"),
    GetPlaceAPI("/maps/api/place/get/json");
  //  PutPlaceAPI();
    private String Resource;
    APIResouces(String Resource){
        this.Resource=Resource;
    }

    public String getResource(){
        return Resource;
    }

}
