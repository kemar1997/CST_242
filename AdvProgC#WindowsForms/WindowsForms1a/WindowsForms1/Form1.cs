using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsForms1
{
    public partial class Form1 : Form
    {
        /// <summary>
        /// Calls the InitialComponent() method in 'Form1.Designer.cs which draws the form
        /// </summary>
        public Form1()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Displays a startup message to the user in a dialog window
        /// </summary>
        /// <param name="sender">A reference to the Form object</param>
        /// <param name="e">A reference to the click event</param>
        private void Form1_Load(object sender, EventArgs e)
        {
            MessageBox.Show("Please fill in the following 'Insurance Quote' form and submit", "Let's Get Started");
        }

        /// <summary>
        /// Calcuates an insurance quote from the 'Name' and 'Age' TextBoxes, 
        /// 'Female' and 'Male' RadioButtons, 'NonSmoker' CheckBox and 'Region' ComboBox
        /// Catches Exceptions for: 
        ///     'Name' TextBox is blank
        ///     'Age' TextBox is non-numeric
        ///     Neither 'Female' nor 'Male' RadioButton is selected
        ///     No item is selected from the 'Region' ComboBox
        /// </summary>
        /// <param name="sender">A reference to the Button object</param>
        /// <param name="e">A reference to the Click event</param>
        private void buttonGetQuote_Click(object sender, EventArgs e)
        {
            try
            {
                const int BASE_RATE = 250;

                int genderDiscount = 0, smokerDiscount = 0, regionCharge;

                if (textBoxName.Text == "")
                {
                    throw new Exception("Name is blank");
                }

                int ageRate = getAgeRate(Convert.ToInt32(textBoxAge.Text) );

                if (! (radioButtonMale.Checked || radioButtonFemale.Checked) )
                {
                    throw new Exception("Gender not selected");
                }

                if (radioButtonFemale.Checked)
                {
                    genderDiscount = 50;
                }

                if (checkBoxNonSmoker.Checked)
                {
                    smokerDiscount = 75;
                }

                regionCharge = getRegionCharge();

                displayQuote( getQuote(BASE_RATE, ageRate, genderDiscount, smokerDiscount, regionCharge) );
            }

            catch (FormatException ex)
            {
                MessageBox.Show("Invalid age: " + ex.Message);
            }

            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        /// <summary>
        /// Calculate and return the part of the insurance quote based on age
        /// If age is 20 or less return zero (0)
        /// If age is greater than 20 return $5 times the number of years over 20
        /// Throws an Exception if age is negative
        /// </summary>
        /// <param name="age">The age of the person for the quote</param>
        /// <returns>The part of the insurance quote based on age</returns>
        private int getAgeRate(int age)
        {
            if (age < 0)
            {
                throw new Exception("Invalid age entered");
            }

            if (age <= 20)
            {
                return 0;
            }
            else
            {
                return (age - 20) * 5;
            }
        }

        /// <summary>
        /// Calculate and return the part of the insurance quote based the region of residence
        /// </summary>
        /// <returns>The part of the insurance quote based the region of residence</returns>
        private int getRegionCharge()
        {
            if (comboBoxRegion.SelectedItem.ToString() == "")
            {
                throw new Exception("Region of residence not selected");
            }

            if (comboBoxRegion.SelectedItem.ToString() == "East")
            {
                return 100;
            }
            else if (comboBoxRegion.SelectedItem.ToString() == "South")
            {
                return 65;
            }
            else if (comboBoxRegion.SelectedItem.ToString() == "Central")
            {
                return 75;
            }
            else // comboBoxRegion.SelectedItem.ToString() == "West"
            {
                return 95;
            }
        }

        /// <summary>
        /// Return the insurance quote which is the base rate plus the age rate,
        /// minus the gender discount and the smoker discount, plus the region of residence charge
        /// </summary>
        /// <param name="baseRate">The base rate for an insurance quote</param>
        /// <param name="ageRate">The amount added to the insurance quote for age over 20</param>
        /// <param name="genderDiscount">The amount subtracted from the insurance quote for females</param>
        /// <param name="smokerDiscount">The amount subtracted from the insurance quote for nonsmokers</param>
        /// <param name="regionCharge">The amount added to the insurance quote depending upon the insured's region of residence</param>
        /// <returns>The insurance quote</returns>
        private int getQuote(int baseRate, int ageRate, int genderDiscount, int smokerDiscount, int regionCharge)
        {
            return baseRate + ageRate - genderDiscount - smokerDiscount + regionCharge;
        }

        /// <summary>
        /// Display the client name, age, region of residence and the amount of the insurance quote
        /// to the 'Quote' ListBox
        /// </summary>
        /// <param name="quote">The total amount of the insurance quote</param>
        private void displayQuote(int quote)
        {
            listBoxQuote.Items.Clear();
            listBoxQuote.Items.Add("Name: " + textBoxName.Text);
            listBoxQuote.Items.Add("Age: " + textBoxAge.Text);
            listBoxQuote.Items.Add("Region: " + comboBoxRegion.SelectedItem.ToString() );
            listBoxQuote.Items.Add("Quote: $" + quote);
        }
    }
}
