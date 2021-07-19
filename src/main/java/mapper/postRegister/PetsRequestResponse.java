package mapper.postRegister;

import java.util.List;

public class PetsRequestResponse {

    public static Builder builder() {
        return new Builder();
    }

    private int id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private List<Tags> tags;
    private String status;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category name) {
        this.category = category;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    public static class Builder {

        private int id;
        private String name;
        private Category category;
        private List<String> photoUrls;
        private List<Tags> tags;
        private String status;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder withPhotoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls;
            return this;
        }

        public Builder withTags(List<Tags> tags) {
            this.tags = tags;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }


        public PetsRequestResponse createInstance() {

            final PetsRequestResponse registerRequest = new PetsRequestResponse();

            registerRequest.setId(id);
            registerRequest.setName(name);
            registerRequest.setCategory(category);
            registerRequest.setPhotoUrls(photoUrls);
            registerRequest.setTags(tags);
            registerRequest.setStatus(status);
            return registerRequest;

        }

    }


}
