package P12_Visitor.ComputerPart;

import P12_Visitor.Visitor.Customer;

/**
 * @author : ZWH
 * @date : 2024/02/07
 * @Description : cpu
 */
public class CPU extends ComputerPart {
    @Override
    public void access(Customer customer) {
        customer.visitCPU(this);
    }

    @Override
    public double getPrice() {
        return 1000;
    }
}
