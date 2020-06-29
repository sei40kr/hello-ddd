package me.yong_ju.example_project_with_unit_of_work.domain.valueobject;

import java.util.Objects;

public class ModelNumber {
  private final String productCode;
  private final String branch;
  private final String lot;

  public ModelNumber(String productCode, String branch, String lot) {
    Objects.requireNonNull(productCode);
    Objects.requireNonNull(branch);
    Objects.requireNonNull(lot);

    this.productCode = productCode;
    this.branch = branch;
    this.lot = lot;
  }

  @Override
  public String toString() {
    return productCode + "-" + branch + "-" + lot;
  }
}
