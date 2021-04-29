package P01_20210426XYWX80.Q02;

import java.util.*;

/**
 * @author : ZWH 2021/4/28
 * @version : 1.0
 */
public class ComputerShop {
    Map<String, Router> routerMap;

    public ComputerShop() {
        this.routerMap = new HashMap<>();
    }

    public void addRouter(Router oneRouter) {
        routerMap.put(oneRouter.getBrand() + ": " + oneRouter.getModelNumber(), oneRouter);
    }

    public void showRouter() {
        routerMap.forEach((k,v)->{
            System.out.println(v.toString());
        });
    }

    public Set<String> modelNumberSet(){
        Set<String> modelNumberSet = new HashSet<>();
        routerMap.forEach((k,v)->{
            modelNumberSet.add(v.getModelNumber());
        });
        return modelNumberSet;
    }

    public List<Double> priceList(){
        List<Double> priceList = new ArrayList<>();
        routerMap.forEach((k,v)->{
            priceList.add(v.getPrice());
        });
        return priceList;
    }
}
