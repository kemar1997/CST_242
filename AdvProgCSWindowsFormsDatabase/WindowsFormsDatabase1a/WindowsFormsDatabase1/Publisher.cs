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
    /// <summary>
    /// A Windows Form to run the "Publisher" table application.
    /// </summary>
    public partial class Publisher : Form
    {
        /// <summary>
        /// Instance variables representing the global OleDb database elements.
        /// </summary>
        private OleDbConnection connectionPublisher;
        private OleDbDataAdapter dataAdapterPublisher;
        private DataSet dataSetPublisher;
        private DataTable dataTablePublisher;

        /// <summary>
        /// An instance variable index that points to the current record in the "Publisher" table.
        /// </summary>
        private int index;
        
        /// <summary>
        /// Constants used to indicate the machine state for the "Publisher" table application.
        /// </summary>
        private enum EditState
        {
            NOT_EDITING,
            ADDING,
            EDITING
        }

        private EditState editState;

        /// <summary>
        /// 
        /// </summary>
        public Publisher()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Connects to the 'Publisher' table in the Books database, 
        /// sets up the SQL SELECT, INSERT, UPDATE and DELETE commands,
        /// and finds and displays the first record.
        /// </summary>
        /// <param name="sender">Reference to the Form object</param>
        /// <param name="e">Reference to the load event of the Form object</param>
        public void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                connectionPublisher = new OleDbConnection();
                connectionPublisher.ConnectionString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=|DataDirectory|Books.mdb;User Id=admin;Password=;";
                //connectionPublisher.ConnectionString = Configuration ConnectionStrings["connectionStringBooks"].ToString();

                // *** Creating the SQL SELECT command and creating a DataTable containing the Book table rows ***

                OleDbCommand commandPublisherSelect = new OleDbCommand();
                commandPublisherSelect.Connection = connectionPublisher;
                commandPublisherSelect.CommandText = "SELECT * FROM Publisher ORDER BY PublisherCode";

                dataAdapterPublisher = new OleDbDataAdapter();
                dataAdapterPublisher.SelectCommand = commandPublisherSelect;

                dataSetPublisher = new DataSet();
                dataAdapterPublisher.Fill(dataSetPublisher);
                dataTablePublisher = dataSetPublisher.Tables[0];

                DataColumn[] dataColumnPublisherCode = { dataTablePublisher.Columns["PublisherCode"] };
                dataTablePublisher.PrimaryKey = dataColumnPublisherCode;

                // *** Creating the SQL INSERT command for adding new Publisher rows ***

                OleDbCommand commandPublisherInsert = new OleDbCommand();
                dataAdapterPublisher.InsertCommand = insertCommand(commandPublisherInsert);

                // *** Creating the SQL UPDATE command for editing existing Publisher rows ***

                OleDbCommand commandPublisherUpdate = new OleDbCommand();
                dataAdapterPublisher.UpdateCommand = updateCommand(commandPublisherUpdate);

                // *** Creating the SQL DELETE command for deleting current Publisher row ***

                OleDbCommand commandPublisherDelete = new OleDbCommand();
                dataAdapterPublisher.DeleteCommand = deleteCommand(commandPublisherDelete);

                index = 0;
                findRow();
                updateState(EditState.NOT_EDITING);
            }

            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString(), "Exception");
            }
        }

        /// <summary>
        /// Creates the SQL INSERT command with parameters for adding new Publisher rows.
        /// </summary>
        /// <param name="commandPublisherUpdate">An OleDbCommand object</param>
        /// <returns>An OleDbCommand SQL INSERT command</returns>
        private OleDbCommand insertCommand(OleDbCommand commandPublisherInsert)
        {
            commandPublisherInsert.Connection = connectionPublisher;
            commandPublisherInsert.CommandText = "INSERT INTO Publisher VALUES (?, ?, ?)";

            OleDbParameter parameterInsertPublisherCode = new OleDbParameter("PublisherCode", OleDbType.VarChar, 2, "PublisherCode");
            OleDbParameter parameterInsertName = new OleDbParameter("Name", OleDbType.VarChar, 20, "Name");
            OleDbParameter parameterInsertCity = new OleDbParameter("City", OleDbType.VarChar, 20, "City");

            commandPublisherInsert.Parameters.Add(parameterInsertPublisherCode);
            commandPublisherInsert.Parameters.Add(parameterInsertName);
            commandPublisherInsert.Parameters.Add(parameterInsertCity);

            return commandPublisherInsert;
        }

        /// <summary>
        /// Creates the SQL UPDATE command with parameters for editing existing Publisher rows
        /// </summary>
        /// <param name="commandPublisherUpdate">An OleDbCommand object</param>
        /// <returns>An OleDbCommand SQL UPDATE command</returns>
        private OleDbCommand updateCommand(OleDbCommand commandPublisherUpdate)
        {
            commandPublisherUpdate.Connection = connectionPublisher;
            commandPublisherUpdate.CommandText = "UPDATE Publisher "
                                                  + "SET Name = ?, City = ? "
                                                  + "WHERE PublisherCode = ?";

            OleDbParameter parameterUpdateName = new OleDbParameter("Name", OleDbType.VarChar, 20, "Name");
            OleDbParameter parameterUpdateCity = new OleDbParameter("City", OleDbType.VarChar, 20, "City");
            OleDbParameter parameterUpdatePublisherCode = new OleDbParameter("PublisherCode", OleDbType.VarChar, 2, "PublisherCode");

            commandPublisherUpdate.Parameters.Add(parameterUpdateName);
            commandPublisherUpdate.Parameters.Add(parameterUpdateCity);
            commandPublisherUpdate.Parameters.Add(parameterUpdatePublisherCode);

            return commandPublisherUpdate;
        }

        /// <summary>
        /// Creates the SQL DELETE command with parameters for deleting current Publisher row
        /// </summary>
        /// <param name="commandPublisherDelete">An OleDbCommand object</param>
        /// <returns>An OleDbCommand SQL UPDATE command</returns>
        private OleDbCommand deleteCommand(OleDbCommand commandPublisherDelete)
        {
            commandPublisherDelete.Connection = connectionPublisher;
            commandPublisherDelete.CommandText = "DELETE FROM Publisher WHERE PublisherCode = ?";

            OleDbParameter parameterDeletePublisherCode = new OleDbParameter("PublisherCode", OleDbType.VarChar, 2, "PublisherCode");
            commandPublisherDelete.Parameters.Add(parameterDeletePublisherCode);

            return commandPublisherDelete;
        }

        /// <summary>
        /// Find the record at the current index location and call method currentRecord() to display it.
        /// </summary>
        private void findRow()
        {
            DataRow dataRowPublisher = dataTablePublisher.Rows[index];
            currentRecord(dataRowPublisher);
        }

        /// <summary>
        /// Display the contents of the record at the current index location to the textboxes in the form;
        /// additionally calls the method to display the current record's number to the status bar
        /// </summary>
        /// <param name="dataRowPublisher">The data row at the current index location</param>
        private void currentRecord(DataRow dataRowPublisher)
        {
            textBoxPublisherCode.Text = dataRowPublisher["PublisherCode"].ToString();
            textBoxName.Text = dataRowPublisher["Name"].ToString();
            textBoxCity.Text = dataRowPublisher["City"].ToString();

            updateStatusBar();
        }

        /// <summary>
        /// Displays the current record number and total number of records to the StatusStrip status bar
        /// </summary>
        private void updateStatusBar()
        {
            toolStripStatusLabel1.Text = "Record " + (index + 1) + " of " + dataTablePublisher.Rows.Count;
        }

        /// <summary>
        /// Sets the current machine state of the "Publisher" table application.
        /// </summary>
        /// <param name="editState">An 'EditState' enum that specifies the current machine state</param>
        private void updateState(EditState editState)
        {
            this.editState = editState;

            switch (this.editState)
            {
                case EditState.NOT_EDITING:

                    if (dataTablePublisher.Rows.Count >= 2 && index == 0) // 2 or more records and at the first one
                    {
                        setMenuItems(true, true, true, false, false, true, true);
                        setToolbar(false, false, true, true);
                    }
                    else if (dataTablePublisher.Rows.Count >= 2 && index == (dataTablePublisher.Rows.Count - 1)) // 2 or more records and at the last one
                    {
                        setMenuItems(true, true, true, false, false, true, true);
                        setToolbar(true, true, false, false);
                    }
                    else if (dataTablePublisher.Rows.Count >= 2)  // 2 or more records and any other record
                    {
                        setMenuItems(true, true, true, false, false, true, true);
                        setToolbar(true, true, true, true);
                    }
                    else if (dataTablePublisher.Rows.Count == 1) // 1 record
                    {
                        setMenuItems(true, true, true, false, false, true, false);
                        setToolbar(false, false, false, false);
                    }
                    else if (dataTablePublisher.Rows.Count == 0) // no records
                    {
                        setMenuItems(true, true, false, false, false, false, false);
                        setToolbar(false, false, false, false);
                    }

                    setReadOnly(true);
                    break;

                case EditState.ADDING:
                case EditState.EDITING:

                    setMenuItems(false, false, false, true, true, false, false);
                    setToolbar(false, false, false, false);

                    setReadOnly(false);
                    textBoxPublisherCode.Focus();
                    break;
            }
        }

        /// <summary>
        /// Sets the enabled properties of the items on the menu bar based on the machine state.
        /// </summary>
        /// <param name="file">Indicates whether or not 'fileToolStripMenuItem' is enabled</param>
        /// <param name="newP">Indicates whether or not 'newToolStripMenuItem' is enabled</param>
        /// <param name="edit">Indicates whether or not 'editToolStripMenuItem1' is enabled</param>
        /// <param name="update">Indicates whether or not 'updateToolStripMenuItem' is enabled</param>
        /// <param name="undo">Indicates whether or not 'undoToolStripMenuItem' is enabled</param>
        /// <param name="delete">Indicates whether or not 'deleteToolStripMenuItem' is enabled</param>
        /// <param name="findPublisher">Indicates whether or not 'findPublisherToolStripMenuItem' is enabled</param>
        private void setMenuItems(bool file, bool newP, bool edit, bool update, bool undo, bool delete, bool findPublisher)
        {
            fileToolStripMenuItem.Enabled = file;
            newToolStripMenuItem.Enabled = newP;
            editToolStripMenuItem1.Enabled = edit;
            updateToolStripMenuItem.Enabled = update;
            undoToolStripMenuItem.Enabled = undo;
            deleteToolStripMenuItem.Enabled = delete;
            findPublisherToolStripMenuItem.Enabled = findPublisher;
        }

        /// <summary>
        /// Sets the enabled properties of the buttons on the tool bar based on the machine state.
        /// </summary>
        /// <param name="first">Indicates whether or not 'toolStripButtonFirst' is enabled</param>
        /// <param name="previous">Indicates whether or not 'toolStripButtonPrevious' is enabled</param>
        /// <param name="next">Indicates whether or not 'toolStripButtonNext' is enabled</param>
        /// <param name="last">Indicates whether or not 'toolStripButtonLast' is enabled</param>
        private void setToolbar(bool first, bool previous, bool next, bool last)
        {
            toolStripButtonFirst.Enabled = first;
            toolStripButtonPrevious.Enabled = previous;
            toolStripButtonNext.Enabled = next;
            toolStripButtonLast.Enabled = last;
        }

        /// <summary>
        /// Sets the read-only property of the textboxes in the form based on the machine state.
        /// </summary>
        /// <param name="readOnly">Specifies if textboxes should be read-only</param>
        private void setReadOnly(bool readOnly)
        {
            textBoxPublisherCode.ReadOnly = readOnly;
            textBoxName.ReadOnly = readOnly;
            textBoxCity.ReadOnly = readOnly;
        }

        /// <summary>
        /// Instantiates and displays the 'BooksByPublisher' form
        /// </summary>
        /// <param name="sender">Reference to the 'booksByPublisherToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the click event of the 'booksByPublisherToolStripMenuItem' menu item object</param>
        private void booksByPublisherToolStripMenuItem_Click(object sender, EventArgs e)
        {
            BooksByPublisher booksByPublisher = new BooksByPublisher();
            booksByPublisher.Show();
        }

        /// <summary>
        /// Closes the 'Publishers' windows form and ends the application
        /// </summary>
        /// <param name="sender">Reference to the 'exitToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the click event of the 'exitToolStripMenuItem' menu item object</param>
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            connectionPublisher.Close();
            this.Close();
        }

        /// <summary>
        /// Moves to a specific record based upon which button was clicked on the ToolStrip toolbar
        /// </summary>
        /// <param name="sender">Reference to the 'toolStripPublisher' tool bar object</param>
        /// <param name="e">Reference to the click event of the 'toolStripPublisher' tool bar object</param>
        private void toolStripPublisher_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {
            switch (e.ClickedItem.ToolTipText)
            {
                case "First":
                    index = 0;
                    break;
                case "Previous":
                    index--;
                    break;
                case "Next":
                    index++;
                    break;
                case "Last":
                    index = dataTablePublisher.Rows.Count - 1;
                    break;
            }

            findRow();
            updateState(EditState.NOT_EDITING);
        }

        /// <summary>
        /// Puts the state of the machine for the Publisher table into a "new record" state.
        /// </summary>
        /// <param name="sender">Reference to the 'newToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the click event of the 'newToolStripMenuItem' menu item object</param>
        private void newToolStripMenuItem_Click(object sender, EventArgs e)
        {
            textBoxPublisherCode.Clear();
            textBoxName.Clear();
            textBoxCity.Clear();

            statusStripRecordCounter.Items[0].Text = "New Record";
            updateState(EditState.ADDING);
        }

        /// <summary>
        /// Puts the state of the machine for the Publisher table into an "edit record" state.
        /// </summary>
        /// <param name="sender">Reference to the 'editToolStripMenuItem1' menu item object</param>
        /// <param name="e">Reference to the click event of the 'editToolStripMenuItem1' menu item object</param>
        private void editToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            updateState(EditState.EDITING);
        }

        /// <summary>
        /// Updates the Publisher DataTable object in RAM for a new or updated publisher record.
        /// </summary>
        /// <param name="sender">Reference to the 'updateToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the click event of the 'updateToolStripMenuItem' menu item object</param>
        private void updateToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                if (this.editState == EditState.ADDING)
                {
                    DataRow dataRowNewPublisher = dataTablePublisher.NewRow();

                    dataRowNewPublisher["PublisherCode"] = textBoxPublisherCode.Text.ToUpper();
                    dataRowNewPublisher["Name"] = textBoxName.Text.ToUpper();
                    dataRowNewPublisher["City"] = textBoxCity.Text.ToUpper();

                    dataTablePublisher.Rows.Add(dataRowNewPublisher);
                    index = dataTablePublisher.Rows.Count - 1;

                    updateStatusBar();
                }
                else if (this.editState == EditState.EDITING)
                {
                    dataTablePublisher.Rows[index].BeginEdit();

                    //dataTablePublisher.Rows[index].Items["Title"] = textBoxPublisherCode.Text.ToUpper();


                    dataTablePublisher.Rows[index].EndEdit();

                }

                savePublisher();
            }

            catch (System.ArgumentException ex)
            {
                dataTablePublisher.Rows[index].CancelEdit();
                MessageBox.Show("Invalid data", "Input Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            catch (System.Data.ConstraintException ex)
            {
                dataTablePublisher.Rows[index].CancelEdit();
                MessageBox.Show("Duplicate Book number", "Input Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            catch (System.Exception ex)
            {
                dataTablePublisher.Rows[index].CancelEdit();
                MessageBox.Show(ex.Message, "Input Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            updateState(EditState.NOT_EDITING);
        }

        /// <summary>
        /// Writes the updates to the Publisher table to the database on disk for a new or updated publisher records.
        /// </summary>
        private void savePublisher()
        {
            try
            {
                DataSet dataSetPublisherUpdate = dataSetPublisher.GetChanges();

                if (dataSetPublisherUpdate != null)
                {
                    dataAdapterPublisher.Update(dataSetPublisherUpdate);
                    dataSetPublisherUpdate.AcceptChanges();
                }
            }

            catch (System.Exception ex)
            {
                MessageBox.Show(ex.Message, "Update Error", MessageBoxButtons.OK, MessageBoxIcon.Stop);
            }
        }

        /// <summary>
        /// Cancels a "new" or "edit" publisher record operation.
        /// </summary>
        /// <param name="sender">Reference to the 'undoToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the click event of the 'undoToolStripMenuItem' menu item object</param>
        private void undoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            findRow();
            updateState(EditState.NOT_EDITING);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void findByCodeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void findByTitleToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Cancels the closing of the Form if the current machine state is ADDING or EDITING.
        /// </summary>
        /// <param name="sender">Reference to the Form object</param>
        /// <param name="e">Reference to the closing event of the Form object</param>
        private void Form_Closing(object sender, FormClosingEventArgs e)
        {
            if (editState == EditState.ADDING || editState == EditState.EDITING)
            {
                e.Cancel = true;
            }
        }
    }
}
