package language.arith;

import language.BinaryOperator;
import language.Operand;
import language.Operator;


/**
 * The {@code DivOperator} is an operator that performs addition on two
 * integers.
 * @author jcollard, jddevaug
 *
 */
public class DivOperator extends BinaryOperator<Integer> {
  @Override
  public void setOperand(int i, Operand<Integer> operand) {
    super.setOperand(i, operand);
      if (i == 1){
      if (operand.getValue() == 0){
        throw new IllegalStateException("Operator should not allow the denominator to be set to zero");
      }

  }
  }
  /**
   * {@inheritDoc}.
   */
  @Override
  public Operand<Integer> performOperation() {
    Operand<Integer> op0 = this.getOp0();
    Operand<Integer> op1 = this.getOp1();

    if (op0 == null || op1 == null) {
      throw new IllegalStateException("Could not perform operation prior to operands being set.");
    }



    Integer result = op0.getValue() / op1.getValue();
    return new Operand<Integer>(result);
  }

}

