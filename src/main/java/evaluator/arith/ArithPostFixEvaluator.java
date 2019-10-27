package evaluator.arith;

import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;
import language.Operand;
import language.Operator;
import parser.arith.ArithPostFixParser;
import stack.LinkedStack;
import stack.StackInterface;




/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostFixEvaluator implements PostFixEvaluator<Integer> {

  private final StackInterface<Operand<Integer>> stack;

  /**
   * Constructs an {@link ArithPostFixEvaluator}.
   */
  public ArithPostFixEvaluator() {
    //TODO Initialize to your LinkedStack
    this.stack = new LinkedStack<Operand<Integer>>();
  }

  /**
   * Evaluates a postfix expression.
   * @return the result 
   */
  @Override
  public Integer evaluate(String expr) {
    // TODO Use all of the things they've built so far to 
    // create the algorithm to do post fix evaluation

    ArithPostFixParser parser = new ArithPostFixParser(expr);
    while (parser.hasNext()) {
//      Type type
      switch (parser.nextType()) { 
        case OPERAND:
          //TODO What do we do when we see an operand?
          stack.push(parser.nextOperand());
          break;
        case OPERATOR:
          //TODO What do we do when we see an operator?

          Operator<Integer> operatorStack = parser.nextOperator();
          if(operatorStack.getNumberOfArguments() == 1){
            operatorStack.setOperand(0, stack.pop());
          }
          else {
            operatorStack.setOperand(1, stack.pop());
            operatorStack.setOperand(0, stack.pop());
          }
          Operand<Integer> result = operatorStack.performOperation();
          stack.push(result);


          break;
        default:
          //TODO If we get here, something went terribly wrong
          throw new IllegalStateException("Parser returned an invalid Type.");

      }
    }

    //TODO What do we return?
    Integer result = stack.pop().getValue();
    if(!stack.isEmpty()){
      throw new IllegalPostFixExpressionException();
    }
    return result;
  }



}