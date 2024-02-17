package P12_Visitor.ComputerPart;

import P12_Visitor.Visitor.Customer;

/**
 * @author : ZWH
 * @date : 2024/02/07
 * @Description : 电脑元器件抽象类
 */
public abstract class ComputerPart {
    abstract public void access(Customer customer);
    abstract public double getPrice();
}
