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

namespace Project11_CST242 {
    /// <summary>
    /// A Windows Forms application to process the "Publisher" table.
    /// </summary>
    public partial class Book : Form {

        /// <summary>
        /// Instance variables representing the global OleDb database elements.
        /// </summary>
        private OleDbConnection connectionBook;
        private OleDbDataAdapter dataAdapterBook;
        private DataSet dataSetBook;
        private DataTable dataTableBook;

        /// <summary>
        /// An instance variable index that points to the current record in the "Book" table.
        /// </summary>
        private int index;

        /// <summary>
        /// Constants used to represent the machine "state" for the "Book" table application.
        /// </summary>
        private enum EditState {
            NOT_EDITING,
            ADDING,
            EDITING
        }

        /// <summary>
        /// Variable to store the current machine "state" of the "Book" table application.
        /// </summary>
        private EditState editState;

        public Book() {
            InitializeComponent();
        }

        private void Book_Load(object sender, EventArgs e) {
            try {
                connectionBook = new OleDbConnection();
                connectionBook.ConnectionString = BooksClass.booksConnectionString;

                // *** Creating the SQL SELECT command and creating a DataTable containing the Book table rows ***

                OleDbCommand commandBookSelect = new OleDbCommand();
                commandBookSelect.Connection = connectionBook;
                commandBookSelect.CommandText = "SELECT [BookCode], [PublisherCode], [Title], [Type], [Price] FROM Book ORDER BY BookCode";

                dataAdapterBook = new OleDbDataAdapter();
                dataAdapterBook.SelectCommand = commandBookSelect;

                dataSetBook = new DataSet();
                dataAdapterBook.Fill(dataSetBook);
                dataTableBook = dataSetBook.Tables[0];

                DataColumn[] dataColumnBookCode = { dataTableBook.Columns["BookCode"] };
                dataTableBook.PrimaryKey = dataColumnBookCode;

                // *** Creating the SQL INSERT command for adding new Book rows ***

                OleDbCommand commandBookInsert = new OleDbCommand();
                dataAdapterBook.InsertCommand = insertCommand(commandBookInsert);

                // *** Creating the SQL UPDATE command for editing existing Book rows ***

                OleDbCommand commandBookUpdate = new OleDbCommand();
                dataAdapterBook.UpdateCommand = updateCommand(commandBookUpdate);

                // *** Creating the SQL DELETE command for deleting current Book row ***

                OleDbCommand commandBookDelete = new OleDbCommand();
                dataAdapterBook.DeleteCommand = deleteCommand(commandBookDelete);

                index = 0;
                findRow();
                updateState(EditState.NOT_EDITING);
            }
            catch (Exception ex) {
                MessageBox.Show(ex.ToString(), "Exception");
            }
        }

        /// <summary>
        /// Creates the SQL INSERT command with parameters for adding new Book rows.
        /// </summary>
        /// <param name="commandBookInsert">An OleDbCommand object</param>
        /// <returns>An OleDbCommand SQL INSERT command</returns>
        private OleDbCommand insertCommand(OleDbCommand commandBookInsert) {
            commandBookInsert.Connection = connectionBook;
            commandBookInsert.CommandText = "INSERT INTO Book VALUSE (?, ?, ?, ?, ?)";

            OleDbParameter parameterInsertBookCode = new OleDbParameter("BookCode", OleDbType.Integer, 4, "BookCode");
            OleDbParameter parameterInsertPublisherCode = new OleDbParameter("PublisherCode", OleDbType.VarChar, 2, "PublisherCode");
            OleDbParameter parameterInsertTitle = new OleDbParameter("Title", OleDbType.VarChar, 255, "Title");
            OleDbParameter parameterInsertType = new OleDbParameter("Type", OleDbType.VarChar, 3, "Type");
            OleDbParameter parameterInsertPrice = new OleDbParameter("Price", OleDbType.Decimal, 3, "Price");

            commandBookInsert.Parameters.Add(parameterInsertBookCode);
            commandBookInsert.Parameters.Add(parameterInsertPublisherCode);
            commandBookInsert.Parameters.Add(parameterInsertTitle);
            commandBookInsert.Parameters.Add(parameterInsertType);
            commandBookInsert.Parameters.Add(parameterInsertPrice);

            return commandBookInsert;
        }

        /// <summary>
        /// Creates the SQL UPDATE command with parameters for editing existing Book rows
        /// </summary>
        /// <param name="commandBookUpdate">An OleDbCommand object</param>
        /// <returns>An OleDbCommand SQL UPDATE command</returns>
        private OleDbCommand updateCommand(OleDbCommand commandBookUpdate) {
            commandBookUpdate.Connection = connectionBook;
            commandBookUpdate.CommandText = "UPDATE Book "
                                             + "SET PublisherCode = ?, Title = ?, Type = ?, Price = ? "
                                             + "WHERE BookCode = ?";

            OleDbParameter parameterUpdatePublisherCode = new OleDbParameter("PublisherCode", OleDbType.VarChar, 2, "PublisherCode");
            OleDbParameter parameterUpdateTitle = new OleDbParameter("Title", OleDbType.VarChar, 255, "Title");
            OleDbParameter parameterUpdateType = new OleDbParameter("Type", OleDbType.VarChar, 3, "Type");
            OleDbParameter parameterUpdatePrice = new OleDbParameter("Price", OleDbType.Decimal, 3, "Price");
            OleDbParameter parameterUpdateBookCode = new OleDbParameter("BookCode", OleDbType.Integer, 4, "BookCode");

            commandBookUpdate.Parameters.Add(parameterUpdatePublisherCode);
            commandBookUpdate.Parameters.Add(parameterUpdateTitle);
            commandBookUpdate.Parameters.Add(parameterUpdateType);
            commandBookUpdate.Parameters.Add(parameterUpdatePrice);
            commandBookUpdate.Parameters.Add(parameterUpdateBookCode);

            return commandBookUpdate;
        }

        /// <summary>
        /// Creates the SQL DELETE command with parameters for deleting current Book row
        /// </summary>
        /// <param name="commandBookDelete">An OleDbCommand object</param>
        /// <returns>An OleDbCommand SQL DELETE command</returns>
        private OleDbCommand deleteCommand(OleDbCommand commandBookDelete) {
            commandBookDelete.Connection = connectionBook;
            commandBookDelete.CommandText = "DELETE FROM Book WHERE BookCode = ?";

            OleDbParameter parameterDeleteBookCode = new OleDbParameter("BookCode", OleDbType.Integer, 4, "BookCode");
            commandBookDelete.Parameters.Add(parameterDeleteBookCode);

            return commandBookDelete;
        }

        /// <summary>
        /// Find the record at the current index location and call method currentRecord() to display it.
        /// </summary>
        private void findRow() {
            DataRow dataRowBook = dataTableBook.Rows[index];
            currentRecord(dataRowBook);
        }

        /// <summary>
        /// Display the contents of the record at the current index location to the textboxes in the form;
        /// additionally calls the method to display the current record's number to the status bar
        /// </summary>
        /// <param name="dataRowBook">The data row at the current index location</param>
        private void currentRecord(DataRow dataRowBook) {
            textBoxBookCode.Text = dataRowBook["BookCode"].ToString();
            textBoxPublisherCode.Text = dataRowBook["PublisherCode"].ToString();
            textBoxTitle.Text = dataRowBook["Title"].ToString();
            textBoxType.Text = dataRowBook["Type"].ToString();
            textBoxPrice.Text = dataRowBook["Price"].ToString();

            updateStatusBar();
        }

        /// <summary>
        /// Displays the current record number and total number of records to the StatusStrip status bar
        /// </summary>
        private void updateStatusBar() {
            toolStripStatusLabel1.Text = "Record " + (index + 1) + " of " + dataTableBook.Rows.Count;
        }

        /// <summary>
        /// Sets the current machine state of the "Book" table application.
        /// </summary>
        /// <param name="editState">An EditState enum that specifies the current machine state</param>
        private void updateState(EditState editState) {
            this.editState = editState;

            switch (this.editState) {
                case EditState.NOT_EDITING:
                    
                    if (dataTableBook.Rows.Count >= 2 && index == 0) { // 2 or more records and at the first one
                        setMenuItems(true, true, true, false, false, true, true);
                        setToolbar(false, false, true, true);
                    } else if (dataTableBook.Rows.Count >= 2 && index == (dataTableBook.Rows.Count - 1)) { // 2 or more records and at the last one
                        setMenuItems(true, true, true, false, false, true, true);
                        setToolbar(true, true, false, false);
                    } else if (dataTableBook.Rows.Count >= 2) { // 2 or more records and any other record
                        setMenuItems(true, true, true, false, false, true, true);
                        setToolbar(true, true, true, true);
                    } else if (dataTableBook.Rows.Count == 1) { // 1 record
                        setMenuItems(true, true, true, false, false, true, false);
                        setToolbar(false, false, false, false);
                    } else if (dataTableBook.Rows.Count == 0) { // no record
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
                    textBoxBookCode.Focus();
                    break;
            }
        }

        /// <summary>
        /// Sets the enabled properties of the items on the menu bar based on the machine state.
        /// </summary>
        /// <param name="file">Indicates whether or not 'fileToolStripMenuItem' is enabled</param>
        /// <param name="newB">Indicates whether or not 'newToolStripMenuItem' is enabled</param>
        /// <param name="edit">Indicates whether or not 'editToolStripMenuItem1' is enabled</param>
        /// <param name="update">Indicates whether or not 'updateToolStripMenuItem' is enabled</param>
        /// <param name="undo">Indicates whether or not 'undoToolStripMenuItem' is enabled</param>
        /// <param name="delete">Indicates whether or not 'deleteToolStripMenuItem' is enabled</param>
        /// <param name="findBook">Indicates whether or not 'findPublisherToolStripMenuItem' is enabled</param>
        private void setMenuItems(bool file, bool newB, bool edit, bool update, bool undo, bool delete, bool findBook) {
            fileToolStripMenuItem.Enabled = file;
            newToolStripMenuItem.Enabled = newB;
            editToolStripMenuItem1.Enabled = edit;
            updateToolStripMenuItem.Enabled = update;
            undoToolStripMenuItem.Enabled = undo;
            deleteToolStripMenuItem.Enabled = delete;
            findBookToolStripMenuItem.Enabled = findBook;
        }

        /// <summary>
        /// Sets the enabled properties of the buttons on the tool bar based on the machine state.
        /// </summary>
        /// <param name="first">Indicates whether or not 'toolStripButtonFirst' is enabled</param>
        /// <param name="previous">Indicates whether or not 'toolStripButtonPrevious' is enabled</param>
        /// <param name="next">Indicates whether or not 'toolStripButtonNext' is enabled</param>
        /// <param name="last">Indicates whether or not 'toolStripButtonLast' is enabled</param>
        private void setToolbar(bool first, bool previous, bool next, bool last) {
            toolStripButtonFirst.Enabled = first;
            toolStripButtonPrev.Enabled = previous;
            toolStripButtonNext.Enabled = next;
            toolStripButtonLast.Enabled = last;
        }

        /// <summary>
        /// Sets the read-only property of the textboxes in the form based on the machine state.
        /// </summary>
        /// <param name="readOnly">Specifies if textboxes should be read-only</param>
        private void setReadOnly(bool readOnly) {
            textBoxBookCode.ReadOnly = readOnly;
            textBoxPublisherCode.ReadOnly = readOnly;
            textBoxTitle.ReadOnly = readOnly;
            textBoxType.ReadOnly = readOnly;
            textBoxPrice.ReadOnly = readOnly;
        }

        private void bookTableToolStripMenuItem_Click(object sender, EventArgs e)
        {
            BookTable bookTable = new BookTable();
            bookTable.Show();
        }

        /// <summary>
        /// Closes the "Book" Windows Form and ends the application.
        /// </summary>
        /// <param name="sender">Reference to the 'exitToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the Click event of the 'exitToolStripMenuItem' menu item object</param>
        private void exitToolStripMenuItem_Click(object sender, EventArgs e) {
            connectionBook.Close();
            this.Close();
        }

        /// <summary>
        /// Moves to a specific record based upon which button was clicked on the ToolStrip toolbar.
        /// </summary>
        /// <param name="sender">Reference to the 'toolStripBook' tool bar object</param>
        /// <param name="e">Reference to the ItemClicked event of the 'toolStripBook' tool bar object</param>
        private void toolStripBook_ItemClicked(object sender, ToolStripItemClickedEventArgs e) {
            switch (e.ClickedItem.ToolTipText) {
                case "First":
                    index = 0;
                    break;
                case "Prev":
                    index--;
                    break;
                case "Next":
                    index++;
                    break;
                case "Last":
                    index = dataTableBook.Rows.Count - 1;
                    break;
            }

            findRow();
            updateState(EditState.NOT_EDITING);
        }

        /// <summary>
        /// Puts the state of the machine for the Book table into a "new record" state.
        /// </summary>
        /// <param name="sender">Reference to the 'newToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the click event of the 'newToolStripMenuItem' menu item object</param>
        private void newToolStripMenuItem_Click(object sender, EventArgs e) {
            textBoxBookCode.Clear();
            textBoxPublisherCode.Clear();
            textBoxTitle.Clear();
            textBoxType.Clear();
            textBoxPrice.Clear();

            toolStripStatusLabel1.Text = "New Record";
            updateState(EditState.ADDING);
        }

        /// <summary>
        /// Puts the state of the machine for the Book table into an "edit record" state.
        /// </summary>
        /// <param name="sender">Reference to the 'editToolStripMenuItem1' menu item object</param>
        /// <param name="e">Reference to the click event of the 'editToolStripMenuItem1' menu item object</param>
        private void editToolStripMenuItem1_Click(object sender, EventArgs e) {
            updateState(EditState.EDITING);
        }

        /// <summary>
        /// Updates the Book DataTable object in RAM for a new or updated book record.
        /// </summary>
        /// <param name="sender">Reference to the 'updateToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the click event of the 'updateToolStripMenuItem' menu item object</param>
        private void updateToolStripMenuItem_Click(object sender, EventArgs e) {
            try {
                if (this.editState == EditState.ADDING) {
                    DataRow dataRowNewBook = dataTableBook.NewRow();

                    dataRowNewBook["BookCode"] = textBoxBookCode.Text;
                    dataRowNewBook["PublisherCode"] = textBoxPublisherCode.Text.ToUpper();
                    dataRowNewBook["Title"] = textBoxTitle.Text;
                    dataRowNewBook["Type"] = textBoxType.Text;
                    dataRowNewBook["Price"] = textBoxPrice.Text;

                    dataTableBook.Rows.Add(dataRowNewBook);
                    index = dataTableBook.Rows.Count - 1;

                    updateStatusBar();
                } else if (this.editState == EditState.EDITING) {
                    DataRow dataRowEditBook = dataTableBook.Rows[index];

                    dataRowEditBook.BeginEdit();

                    dataRowEditBook["BookCode"] = textBoxBookCode.Text;
                    dataRowEditBook["PublisherCode"] = textBoxPublisherCode.Text.ToUpper();
                    dataRowEditBook["Title"] = textBoxTitle.Text;
                    dataRowEditBook["Type"] = textBoxType.Text;
                    dataRowEditBook["Price"] = textBoxPrice.Text;

                    dataRowEditBook.EndEdit();
                }

                saveBook();

            } catch (System.ArgumentException ex) {
                dataTableBook.Rows[index].CancelEdit();
                MessageBox.Show("Invalid data", "Input Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            } catch (System.Data.ConstraintException ex) {
                dataTableBook.Rows[index].CancelEdit();
                MessageBox.Show("Duplicate Book Code / Publisher Code", "Input Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            } catch (System.Exception ex){
                dataTableBook.Rows[index].CancelEdit();
                MessageBox.Show(ex.Message, "Input Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            updateState(EditState.NOT_EDITING);
        }

        /// <summary>
        /// Writes the updates to the Book table to the database on disk for a new or updated book records.
        /// </summary>
        private void saveBook() {
            try
            {
                DataSet dataSetBookUpdate = dataSetBook.GetChanges();

                if (dataSetBookUpdate != null)
                {
                    dataAdapterBook.Update(dataSetBookUpdate);
                    dataSetBookUpdate.AcceptChanges();
                }
            }
            catch (System.Exception ex) {
                MessageBox.Show(ex.Message, "Update Error", MessageBoxButtons.OK, MessageBoxIcon.Stop);
            }
        }

        /// <summary>
        /// Cancels a "new" or "edit" book record operation.
        /// </summary>
        /// <param name="sender">Reference to the 'undoToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the Click event of the 'undoToolStripMenuItem' menu item object</param>
        private void undoToolStripMenuItem_Click(object sender, EventArgs e) {
            findRow();
            updateState(EditState.NOT_EDITING);
        }

        /// <summary>
        /// Deletes the currently viewed book record.
        /// </summary>
        /// <param name="sender">Reference to the 'deleteToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the Click event of the 'deleteToolStripMenuItem' menu item object</param>
        private void deleteToolStripMenuItem_Click(object sender, EventArgs e) {
            if (MessageBox.Show("Really delete this title?", "Confirm Deletion", MessageBoxButtons.YesNo, MessageBoxIcon.Question, MessageBoxDefaultButton.Button2) == DialogResult.Yes) {
                DataRow dataRowBook = dataTableBook.Rows[index];
                dataRowBook.Delete();

                saveBook();
                index = 0;
                findRow();
                updateState(EditState.NOT_EDITING);
            }
        }

        /// <summary>
        /// Opens the 'FindBookByCode' form and finds a publisher record by book code.
        /// </summary>
        /// <param name="sender">Reference to the 'findByCodeToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the Click event of the 'findByCodeToolStripMenuItem' menu item object</param>
        private void findByCodeToolStripMenuItem_Click(object sender, EventArgs e) {
            FindBookByCode findBookByCode = new FindBookByCode();
            findBookByCode.Text = "Find Book by Code";
            findBookByCode.ShowDialog();

            String bookCode = findBookByCode.getFindString();

            findBookByCode.Close();

            if (bookCode.Length > 0) {
                DataRow dataRowFindByCode = dataTableBook.Rows.Find(bookCode);

                if (dataRowFindByCode != null) {
                    index = dataTableBook.Rows.IndexOf(dataRowFindByCode);
                    currentRecord(dataRowFindByCode);
                    updateState(EditState.NOT_EDITING);
                }
            }
        }

        /// <summary>
        /// Opens the 'FindBookByTitle' form and finds a publisher record by publisher name.
        /// </summary>
        /// <param name="sender">Reference to the 'findByNameToolStripMenuItem' menu item object</param>
        /// <param name="e">Reference to the Click event of the 'findByNameToolStripMenuItem' menu item object</param>
        private void findByNameToolStripMenuItem_Click(object sender, EventArgs e) {
            FindBookByName findBookByName = new FindBookByName();
            findBookByName.Text = "Find Book By Title";
            findBookByName.ShowDialog();

            String stringBook = findBookByName.getFindString();

            findBookByName.Close();

            if (stringBook.Length > 0) {
                int indexBookCode = stringBook.LastIndexOf(" ");

                String bookCode = stringBook.Substring(indexBookCode + 1);

                DataRow dataRowFindByName = dataTableBook.Rows.Find(bookCode);

                if (dataRowFindByName != null) {
                    index = dataTableBook.Rows.IndexOf(dataRowFindByName);
                    currentRecord(dataRowFindByName);
                    updateState(EditState.NOT_EDITING);
                }
            }
        }

        /// <summary>
        /// Cancels the closing of the Form if the current machine state is ADDING or EDITING.
        /// </summary>
        /// <param name="sender">Reference to the Form object</param>
        /// <param name="e">Reference to the FormClosingEventArgs event of the Form object</param>
        private void Form_Closing(object sender, FormClosingEventArgs e) {
            if (editState == EditState.ADDING || editState == EditState.EDITING)
            {
                e.Cancel = true;
            }
        }

        
    }
}
