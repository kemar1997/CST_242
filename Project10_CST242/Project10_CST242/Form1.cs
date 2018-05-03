using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/// <summary>
/// Kemar, Woonie & Sophia
/// </summary>

namespace Project10_CST242 {
    public partial class Form1 : Form {
        /// <summary>
        /// Calls the InitialComponent() method in 'Form1.Designer.cs which draws the form
        /// </summary>
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e) {

        }

        /// <summary>
        /// Button Event handler that uses MessageBoxes for certain errors that may occur in the form then
        /// displays the result into the ListBox using the displayMonthlyPayment() method.
        /// </summary>
        /// <param name="sender">A reference to the Button object</param>
        /// <param name="e">A reference to the Click event</param>
        private void buttonGetMonthlyPayment_Click(object sender, EventArgs e) {

            if (textBoxName.Text.Equals("")) {
                MessageBox.Show("Name must not be left blank", "Error!!");
            }

            if (textBoxLoanAmount.Text.Equals("")) {
                MessageBox.Show("Invalid Loan Amount", "Error!!");
            }

            if (textBoxInterestRate.Text.Equals("")) {
                MessageBox.Show("Must input a valid interest rate", "Error!!");
            }

            displayMonthlyPayment();
        }

        /// <summary>
        /// A formula that calculates monthly payments according to what the user inputs.
        /// </summary>
        /// <returns>The monthly payment</returns>
        private double loanCalculator() {
                int loanAmount = Convert.ToInt32(textBoxLoanAmount.Text);
                double interest = Convert.ToDouble(textBoxInterestRate.Text);
                int numberOfYears = 0;

                if (radioButton5Yrs.Checked)
                {
                    numberOfYears = 5;
                }
                else if (radioButton10Yrs.Checked)
                {
                    numberOfYears = 10;
                }
                else if (radioButton15Yrs.Checked)
                {
                    numberOfYears = 15;
                }

                double rateOfInterest = interest / 1200;
                int numberOfPayments = numberOfYears * 12;

                double paymentAmount = (rateOfInterest * loanAmount) / (1 - Math.Pow(1 + rateOfInterest, numberOfPayments * -1));

                return Math.Round(paymentAmount, 2);
            
        }

        /// <summary>
        /// Displays client name, loan amount, interest rate, and the monthly payment depending on what the user
        /// inputted into the Form.
        /// </summary>
        private void displayMonthlyPayment() {
            listBoxMonthlyPayment.Items.Clear();
            listBoxMonthlyPayment.Items.Add("Name: " + textBoxName.Text);
            listBoxMonthlyPayment.Items.Add("Loan Amount: " + string.Format("${0:#.00}", Convert.ToDecimal(textBoxLoanAmount.Text) / 1));
            listBoxMonthlyPayment.Items.Add("Interest Rate: " + textBoxInterestRate.Text + "%");
            listBoxMonthlyPayment.Items.Add("Monthly Payment: $" + loanCalculator());
        }

        /// <summary>
        /// Button event handler that clears the form so a user may enter new information
        /// into the Form.
        /// </summary>
        /// <param name="sender">A reference to the Button object</param>
        /// <param name="e">A reference to the Click event</param>
        private void buttonClear_Click(object sender, EventArgs e) {
            textBoxName.Clear();
            textBoxLoanAmount.Clear();
            textBoxInterestRate.Clear();

            if (radioButton5Yrs.Checked == true) {
                radioButton5Yrs.Checked = false;
            } else if (radioButton10Yrs.Checked == true) {
                radioButton10Yrs.Checked = false;
            } else if (radioButton15Yrs.Checked == true) {
                radioButton15Yrs.Checked = false;
            }

            listBoxMonthlyPayment.Items.Clear();
        }
    }
}
