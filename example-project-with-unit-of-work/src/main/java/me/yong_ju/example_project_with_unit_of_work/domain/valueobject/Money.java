package me.yong_ju.example_project_with_unit_of_work.domain.valueobject;

import java.text.MessageFormat;
import java.util.Objects;

public class Money {
  private final double amount;
  private final String currency;

  public Money(double amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  /**
   * <code>
   * var myMoney = new Money(1000, "jpy");
   * var allowance = new Money(3000, "jpy");
   * var result = myMoney.add(allowance);
   * </code>
   *
   * <code>
   * var jpy = new Money(1000, "jpy");
   * var usd = new Money(10, "usd");
   * var result = jpy.add(usd); // &lt;- throws {@code IllegalArgumentException}
   * </code>
   *
   * @param aMoney Another Money to add
   */
  public Money add(Money aMoney) {
    Objects.requireNonNull(aMoney);

    if (!currency.equals(aMoney.currency)) {
      throw new IllegalArgumentException(
          MessageFormat.format("通貨単位が異なります: this={0}, aMoney={1}",
                               this.currency, aMoney.currency));
    }

    return new Money(amount + aMoney.amount, currency);
  }
}
