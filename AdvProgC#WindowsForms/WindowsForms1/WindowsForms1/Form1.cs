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
        public Form1()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Calculates ...
        /// </summary>
        /// <param name="sender">A reference to the button object</param>
        /// <param name="e">A reference to the click event</param>
        private void buttonGetQuote_Click(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Displays a startup message to the user in a dialog window
        /// </summary>
        /// <param name="sender">A reference to the form object</param>
        /// <param name="e">A reference to the load event</param>
        private void Form1_Load(object sender, EventArgs e)
        {
            MessageBox.Show("Please fill in the following 'Insurance Quote' form and submit",
                "Let's Get Started");
        }
    }
}
