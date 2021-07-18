package mission2_car_racing;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        play();
    }

    public static void play(){
        Scanner sc = new Scanner(System.in);

        System.out.println("몇 번 이동하겠습니까?");
        int moveNum = Integer.parseInt(sc.nextLine());

        System.out.println("몇 대의 자동차를 참여시킬까요?");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("각 자동차의 이름을 5자 이하로 입력해주세요. (ex. A, B, C, D)");
        StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");

        // 각 자동차에게 필요한 속성 (1.이름, 2.현재 위치)
        HashMap<String, Integer> cars = new HashMap<String, Integer>();
        while (st.hasMoreTokens()){
            cars.put(st.nextToken(), 0);
        }

        // 이동 시작
        for (int i = 0; i < moveNum; i++) {
            moveCars(cars);
        }

        int max = findMax(cars);

        String[] winner = new String[n];
        int idx = 0;
        for (String carName : cars.keySet()){
            System.out.println(carName+","+cars.get(carName));
            if (cars.get(carName) == max){
                winner[idx++] = carName;
            }
        }

        for (int i = 0; i < winner.length; i++){
            if (winner[i] == null){
                break;
            }
            System.out.println("winner : "+winner[i]);
        }
    }

    public static void moveCars(HashMap<String, Integer> cars){
        for (String carName : cars.keySet()) {
            int move = (int)(Math.random()*10);
            if (move > 3){
                cars.replace(carName, cars.get(carName)+1);
                System.out.println(carName+"가 전진하였습니다.");
            }
        }
    }

    public static int findMax(HashMap<String, Integer> cars){
        int max = 0;
        for (String carName : cars.keySet()){
            if (cars.get(carName) > max){
                max = cars.get(carName);
            }
        }
        return max;
    }
}
