package P12_Visitor;

import P12_Visitor.Visitor.EnterpriseCustomer;
import P12_Visitor.Visitor.PersonalCustomer;

/**
 * @author : ZWH
 * @date : 2024/02/07
 * @Description : 访问者模式，测试
 */
public class Main {
    public static void main(String[] args) {
        PersonalCustomer p = new PersonalCustomer();
        new Computer().access(p);
        System.out.println(p.totalPrice);

        EnterpriseCustomer e = new EnterpriseCustomer();
        new Computer().access(e);
        System.out.println(e.totalPrice);
    }
}
