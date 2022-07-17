package main.java.biciU.Services;

import main.java.biciU.Entities.Bicycle;
import main.java.biciU.Entities.User;
import main.java.biciU.Enums.BikeColor;
import main.java.biciU.Enums.BikeType;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EntitiesServices {

    private static final Map<String, User> users = new HashMap<>();
    private static final Map<String, Bicycle> mountainBikes = new HashMap<>();
    private static final Map<String, Bicycle> roadBikes = new HashMap<>();
    private static final BikeColor[] colors =
            {BikeColor.BLUE ,
            BikeColor.BLACK,
            BikeColor.YELLOW,
            BikeColor.WHITE,
            BikeColor.RED};

    public static Optional<User> findUserByID(String ID) {
        return Optional.ofNullable(users.get(ID));
    }

    public static Optional<Bicycle> findBikeByNum(int BIC_num, BikeType bType){

        Optional<Bicycle> answer;
        if(bType==BikeType.MOUNTAIN){
            answer = Optional.ofNullable(mountainBikes.get(BIC_num));
        }else{
            answer = Optional.ofNullable(roadBikes.get(BIC_num));
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
                    Bicycle oneBike = new Bicycle(i,colors[j],BICthis,type);
                    bikeStock.put(BICthis, oneBike);
                }
            }
        }

    }

    public static Bicycle getRandomBikeFromStock(BikeType type){
        int RandBIC = (int)Math.floor(Math.random()*49);
        Bicycle assignedBike = findBikeByNum(RandBIC, type).get();
        return assignedBike;
    }

    private static String BIC_Creator(int BIC_num){
        String newBIC;
        if(BIC_num<10){
            newBIC = "BIC-0" + BIC_num;
        }else{ newBIC = "BIC-" + BIC_num;}
        return newBIC;
    }

    private static String ticketCode_Creator(int code_num){
        String newCode;
        if(code_num<10){
            newCode = "BIC-00" + code_num;
        }else if(code_num<100){
                newCode = "BIC-0" + code_num;
        }else{ newCode = "BIC-" + code_num;}
        return newCode;
    }




}


