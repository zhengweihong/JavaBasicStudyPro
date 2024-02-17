package P12_Visitor.ComputerPart;

import P12_Visitor.Visitor.Customer;

/**
 * @author : ZWH
 * @date : 2024/02/07
 * @Description : 主板
 */
public class Board extends ComputerPart {
    @Override
    public void access(Customer customer) {
        customer.visitBoard(this);
    }

    @Override
    public double getPrice() {
        return 200;
    }
}
