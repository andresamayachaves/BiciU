package co.com.biciu.Services;

import co.com.biciu.Entities.Bicycle;
import co.com.biciu.Entities.User;
import co.com.biciu.Enums.BikeColor;
import co.com.biciu.Enums.BikeType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EntitiesServices {

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Bicycle> mountainBikes = new HashMap<>();
    private final Map<String, Bicycle> roadBikes = new HashMap<>();
    private final BikeColor[] colors =
            {BikeColor.BLUE ,
            BikeColor.BLACK,
            BikeColor.YELLOW,
            BikeColor.WHITE,
            BikeColor.RED};

    public Optional<User> findUserByID(String ID) {
        return Optional.ofNullable(this.users.get(ID));
    }

    public Optional<Bicycle> findBikeByNum(int BIC_num, BikeType bType){

        Optional<Bicycle> answer;
        if(bType==BikeType.MOUNTAIN){
            answer = Optional.ofNullable(this.mountainBikes.get(BIC_num));
        }else{
            answer = Optional.ofNullable(this.roadBikes.get(BIC_num));
        }
        return answer;
    }

    public static void createDefaultBikeStock(){
        createDefaultBikeStockType(50, mountainBikes, BikeType.MOUNTAIN);
        createDefaultBikeStockType(50, roadBikes, BikeType.ROAD);
    }

    public static void createDefaultBikeStockType(int SizeEach, Map<String, Bicycle> bikeStock, BikeType type){
        for (int i=0; i<SizeEach;i++){
            for(int j=0; j<colors.length;j++){
                for(int k=0;i<10;k++){
                    String BICthis  = BIC_Creator(i);
                    Bicycle oneBike = new Bicycle(i,colors[j], BICthis,type);
                    bikeStock.put(BICthis, oneBike);
                }
            }
        }

    }

    public Bicycle getRandomBikeFromStock(BikeType type){
        int RandBIC = (int)Math.floor(Math.random()*49);
        Bicycle assignedBike = findBikeByNum(RandBIC, type).get();
        return assignedBike;
    }

    private String BIC_Creator(int BIC_num){
        String newBIC;
        if(BIC_num<10){
            newBIC = "BIC-0" + BIC_num;
        }else{ newBIC = "BIC-" + BIC_num;}
        return newBIC;
    }




}


