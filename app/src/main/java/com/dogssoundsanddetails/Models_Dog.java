package com.dogssoundsanddetails;

public class Models_Dog {
    private int dog_photo_Id;
    private String dog_names_id;
    private int dog_details_id;
    private int soundId;

    public Models_Dog(){

    }

    public Models_Dog(int akita_puppy, String akita_puppy1, int dog_details_id, int soundId) {

        this.dog_photo_Id=akita_puppy;
        this.dog_names_id=akita_puppy1;
        this.dog_details_id=dog_details_id;
        this.soundId=soundId;
    }


    public int getDog_photo_Id() {
        return dog_photo_Id;
    }

    public String getDog_names_id() {
        return dog_names_id;
    }

    public int getDog_details_id() {
        return dog_details_id;
    }

    public int getSoundId() {
        return soundId;
    }
/*

    public Models_Dog(int dog_photo_Id, String dog_names_id, String dog_detalis, int soundId){

        this.dog_photo_Id=dog_photo_Id;
        this.dog_names_id=dog_names_id;
        this.dog_details_id=dog_detalis;
        this.soundId=soundId;
    }

*/



  /*  public Models_Dog(int soundId) {
        this.soundId = soundId;
    }


    public Models_Dog(int dog_photo_Id){
            this.dog_photo_Id=dog_photo_Id;

   }*/

 /*   int getSoundId() {
        return soundId;
    }
*/



/*

    public String getDog_names_id() {
        return dog_names_id;
    }
*/


   /* String get_photo_id(){
        return dog_photo_Id;
    }
*/



}
