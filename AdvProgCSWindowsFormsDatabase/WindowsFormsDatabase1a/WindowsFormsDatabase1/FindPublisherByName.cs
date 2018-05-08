using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.OleDb;

namespace WindowsFormsDatabase1
{
    public partial class FindPublisherByName : Form
    {
        /// <summary>
        /// The "findString" is the publisher name selected from the ListBox.
        /// </summary>
        private String findString;

        /// <summary>
        /// Calls the "designer" methods to draw the "FindPublisherByName" Windows Forms object.
        /// </summary>
        public FindPublisherByName()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Initializes the "findString" to an empty String.  Then connects to the "Publisher" table 
        /// in the Books database and adds the publisher names to the ListBox.
        /// </summary>
        /// <param name="sender">Reference to the Form object</param>
        /// <param name="e">Reference to the Load event of the Form object</param>
        private void FindPublisherByName_Load(object sender, EventArgs e)
        {
            findString = "";

            OleDbConnection connectionFindPublisher = new OleDbConnection();
            connectionFindPublisher.ConnectionString = BooksClass.booksConnectionString;

            OleDbCommand commandFindPublisher = new OleDbCommand();
            commandFindPublisher.CommandText = "SELECT Name + Space(100) + PublisherCode AS PublisherList FROM Publisher ORDER BY Name";
            commandFindPublisher.Connection = connectionFindPublisher;

            OleDbDataAdapter dataAdaptorFindPublisher = new OleDbDataAdapter();
            dataAdaptorFindPublisher.SelectCommand = commandFindPublisher;

            DataSet dataSetFindPublisher = new DataSet();
            dataAdaptorFindPublisher.Fill(dataSetFindPublisher);

            DataTable dataTableFindPublisher = new DataTable();
            dataTableFindPublisher = dataSetFindPublisher.Tables[0];

            foreach (DataRow dataRowFindPublisher in dataTableFindPublisher.Rows)
            {
                listBoxFind.Items.Add( dataRowFindPublisher["PublisherList"] );
            }
        }

        /// <summary>
        /// Updates the "Find String" with the value selected from the ListBox.
        /// </summary>
        /// <param name="findString">The String value selected from the ListBox</param>
        public void setFindString(String findString)
        {
            this.findString = findString;
        }

        /// <summary>
        /// Retrieves the "Find String" with the value previously selected from the ListBox.
        /// </summary>
        /// <returns>The String value previously selected from the ListBox</returns>
        public String getFindString()
        {
            return findString;
        }

        /// <summary>
        /// Retrieves the selected String from the ListBox, updates the "FindString" instance variable, 
        /// and then "hides" this window giving control back to the parent "Publisher" window.
        /// </summary>
        /// <param name="sender">Reference to the 'listBoxFind' ListBox object</param>
        /// <param name="e">Reference to the SelectedIndexChanged event of the 'listBoxFind' ListBox object</param>
        private void listBoxFind_SelectedIndexChanged(object sender, EventArgs e)
        {
            setFindString(listBoxFind.Text);
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
