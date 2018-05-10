using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.OleDb;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Project11_CST242
{
    public partial class FindBookByName : Form {

        /// <summary>
        /// The "findString" is the book title selected from the ListBox.
        /// </summary>
        private String findString;

        /// <summary>
        /// Calls the "designer" methods to draw the "FindBookByName" Windows Forms object.
        /// </summary>
        public FindBookByName() {
            InitializeComponent();
        }

        /// <summary>
        /// Initializes the "findString" to an empty String.  Then connects to the "Book" table 
        /// in the Books database and adds the book titles to the ListBox.
        /// </summary>
        /// <param name="sender">Reference to the Form object</param>
        /// <param name="e">Reference to the Load event of the Form object</param>
        private void FindBookByName_Load(object sender, EventArgs e) {
            findString = "";

            OleDbConnection connectionFindBook = new OleDbConnection();
            connectionFindBook.ConnectionString = BooksClass.booksConnectionString;

            OleDbCommand commandFindBook = new OleDbCommand();
            commandFindBook.CommandText = "SELECT Title + Space(100) + BookCode AS BookList FROM Book ORDER BY Title";
            commandFindBook.Connection = connectionFindBook;

            OleDbDataAdapter dataAdapterFindBook = new OleDbDataAdapter();
            dataAdapterFindBook.SelectCommand = commandFindBook;

            DataSet dataSetFindBook = new DataSet();
            dataAdapterFindBook.Fill(dataSetFindBook);

            DataTable dataTableFindBook = new DataTable();
            dataTableFindBook = dataSetFindBook.Tables[0];

            foreach (DataRow dataRowFindBook in dataTableFindBook.Rows) {
                listBoxFind.Items.Add( dataRowFindBook["BookList"] );
            }
        }

        /// <summary>
        /// Updates the "Find String" with the value selected from the ListBox.
        /// </summary>
        /// <param name="findString">The String value selected from the ListBox</param>
        public void setFindString(String findString) {
            this.findString = findString;
        }

        /// <summary>
        /// Retrieves the "Find String" with the value previously selected from the ListBox.
        /// </summary>
        /// <returns>The String value previously selected from the ListBox</returns>
        public String getFindString() {
            return findString;
        }

        /// <summary>
        /// Retrieves the selected String from the ListBox, updates the "FindString" instance variable, 
        /// and then "hides" this window giving control back to the parent "Book" window.
        /// </summary>
        /// <param name="sender">Reference to the 'listBoxFind' ListBox object</param>
        /// <param name="e">Reference to the SelectedIndexChanged event of the 'listBoxFind' ListBox object</param>
        private void listBoxFind_SelectedIndexChanged(object sender, EventArgs e) {
            setFindString(listBoxFind.Text);
            this.Hide();
        }

        /// <summary>
        /// Closes the "FindPublisherByName" Windows Form.
        /// </summary>
        /// <param name="sender">Reference to the 'cancelToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the Click event of the 'cancelToolStripMenuItem' menu item object</param>
        private void cancelToolStripMenuItem_Click(object sender, EventArgs e) {
            this.Close();
        }
    }
}
