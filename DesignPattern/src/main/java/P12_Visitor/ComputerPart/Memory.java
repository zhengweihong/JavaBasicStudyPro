package P12_Visitor.ComputerPart;

import P12_Visitor.Visitor.Customer;

/**
 * @author : ZWH
 * @date : 2024/02/07
 * @Description : 内存
 */
public class Memory extends ComputerPart {
    @Override
    public void access(Customer customer) {
        customer.visitMemory(this);
    }

    @Override
    public double getPrice() {
        return 800;
    }
}
