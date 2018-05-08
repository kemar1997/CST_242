using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsDatabase1
{
    public partial class FindPublisherByCode : Form
    {
        /// <summary>
        /// The "findString" is the publisher code returned from the TextBox.
        /// </summary>
        private String findString;

        /// <summary>
        /// Calls the "designer" methods to draw the "FindPublisherByCode" Windows Forms object.
        /// </summary>
        public FindPublisherByCode()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Initializes the "findString" to an empty String.
        /// </summary>
        /// <param name="sender">Reference to the Form object</param>
        /// <param name="e">Reference to the Load event of the Form object</param>
        private void FindPublisherByCode_Load(object sender, EventArgs e)
        {
            findString = "";
        }


        /// <summary>
        /// Updates the "Find String" with the value returned from the TextBox.
        /// </summary>
        /// <param name="findString">The String value returned from the TextBox</param>
        public void setFindString(String findString)
        {
            this.findString = findString;
        }

        /// <summary>
        /// Retrieves the "Find String" with the value previously returned from the TextBox.
        /// </summary>
        /// <returns>The String value previously returned from the TextBox</returns>
        public String getFindString()
        {
            return findString.ToUpper();
        }

        /// <summary>
        /// Returns the selected String from the TextBox, updates the "FindString" instance variable, 
        /// and then "hides" this window giving control back to the parent "Publisher" window.
        /// </summary>
        /// <param name="sender">Reference to the 'buttonFindPublisherCode' Button object</param>
        /// <param name="e">Reference to the Click event of the 'buttonFindPublisherCode' Button object</param>
        private void buttonFindPublisherCode_Click(object sender, EventArgs e)
        {
            setFindString(textBoxFindPublisherCode.Text);
            this.Hide();
        }

        /// <summary>
        /// Closes the "FindPublisherByName" Windows Form.
        /// </summary>
        /// <param name="sender">Reference to the 'cancelToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the Click event of the 'cancelToolStripMenuItem' menu item object</param>
        private void cancelToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
