using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Project11_CST242
{
    public partial class FindBookByCode : Form {
        /// <summary>
        /// The "findString" is the book code returned from the TextBox.
        /// </summary>
        private String findString;

        /// <summary>
        /// Calls the "designer" methods to draw the "FindPublisherByCode" Windows Forms object.
        /// </summary>
        public FindBookByCode() {
            InitializeComponent();
        }

        /// <summary>
        /// Initializes the "findString" to an empty String.
        /// </summary>
        /// <param name="sender">Reference to the Form object</param>
        /// <param name="e">Reference to the Load event of the Form object</param>
        private void FindBookByCode_Load(object sender, EventArgs e) {
            findString = "";
        }

        /// <summary>
        /// Updates the "Find String" with the value returned from the TextBox.
        /// </summary>
        /// <param name="findString">The String value returned from the TextBox</param>
        public void setFindString(String findString) {
            this.findString = findString;
        }

        /// <summary>
        /// Retrieves the "Find String" with the value previously returned from the TextBox.
        /// </summary>
        /// <returns>The String value previously returned from the TextBox</returns>
        public String getFindString() {
            return findString.ToUpper();
        }

        /// <summary>
        /// Returns the selected String from the TextBox, updates the "FindString" instance variable, 
        /// and then "hides" this window giving control back to the parent "Book" window.
        /// </summary>
        /// <param name="sender">Reference to the 'buttonFindBookCode' Button object</param>
        /// <param name="e">Reference to the Click event of the 'buttonFindBookCode' Button object</param>
        private void buttonFindBookCode_Click(object sender, EventArgs e) {
            setFindString(textBoxFindBookCode.Text);
            this.Hide();
        }

        /// <summary>
        /// Closes the "FindBookByCode" Windows Form.
        /// </summary>
        /// <param name="sender">Reference to the 'cancelToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the Click event of the 'cancelToolStripMenuItem' menu item object</param>
        private void cancelToolStripMenuItem_Click(object sender, EventArgs e) {
            this.Close();
        }
    }
}
