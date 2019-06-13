package petstore.models;

public class PetModel {
//    "{\n" +
//            "  \"id\": 0,\n" +
//            "  \"category\": {\n" +
//            "    \"id\": 0,\n" +
//            "    \"name\": \"string\"\n" +
//            "  },\n" +
//            "  \"name\": \"doggie\",\n" +
//            "  \"photoUrls\": [\n" +
//            "    \"string\"\n" +
//            "  ],\n" +
//            "  \"tags\": [\n" +
//            "    {\n" +
//            "      \"id\": 0,\n" +
//            "      \"name\": \"string\"\n" +
//            "    }\n" +
//            "  ],\n" +
//            "  \"status\": \"available\"\n" +
//            "}"

    private int id;
    private CategoryModel categoy;
    private String name;
    private String[] photoUrls;
    private TagModel [] tags;
    private String status;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoy(CategoryModel categoy) {
        this.categoy = categoy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(TagModel[] tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public CategoryModel getCategoy() {
        return categoy;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public TagModel[] getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public PetModel(CategoryModel categoy, String name, String[] photoUrls, TagModel[] tags, String status) {
        this.categoy = categoy;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public PetModel(int id, CategoryModel categoy, String name, String[] photoUrls, TagModel[] tags, String status) {
        this.id = id;
        this.categoy = categoy;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }


}
