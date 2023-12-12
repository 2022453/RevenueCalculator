/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revenuecalculator;

/**
 *
 * @author diogo
 */
public class IrishTaxCalculator implements TaxCalculator {
    private double standardRate;
    private double higherRate;
  
    private double personalTaxCredit;

    // Constructor to initialize tax rates and bands
    public IrishTaxCalculator(double standardRate, double higherRate, double personalTaxCredit) {
        this.standardRate = 0.20;
        this.higherRate = 0.40;
        this.personalTaxCredit = 3550.00;
    }

    public IrishTaxCalculator() {
    }

    
    
    // Implement the calculateIncomeTax method from the interface
    @Override
    public double calculateIncomeTax(double income) {
        double tax = 0;

        // Calculate PAYE tax
        if (income * 12 <= 40000.00) {
            tax = (income * 12) * standardRate;  // 20% for income less than or equal to 40,000 annually
        } else {
            tax = (40000.00 * standardRate) + ((income * 12 - 40000.00) * higherRate);  // 20% for the first 40,000, 40% for the rest
        }

        // Calculate USC tax
        if (income * 12 > 13000.00) {
            double usc = 0.005 * Math.min(12012.00, income * 12);  // 0.5% on the first 12012
            usc += 0.02 * Math.min(10908.00, Math.max(0, income * 12 - 12012));  // 2% on the next 10908
            usc += 0.045 * Math.max(0, income * 12 - 12012.00 - 10908.00);  // 4.5% on the balance
            tax += usc;
        }

        // Calculate PRSI tax
        if (income * 12 > 16896) {
            tax += (income * 12 - 16896) * 0.04;  // 4% for income greater than 16896
        }

        // Subtract tax credit
        tax -= personalTaxCredit;

        // Ensure tax doesn't go below zero (no negative tax)
        return Math.max(0, tax);
    }
}

