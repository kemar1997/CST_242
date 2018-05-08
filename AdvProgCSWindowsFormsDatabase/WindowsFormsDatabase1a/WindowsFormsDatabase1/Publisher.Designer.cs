namespace WindowsFormsDatabase1
{
    partial class Publisher
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Publisher));
            this.label1 = new System.Windows.Forms.Label();
            this.menuStripPublisher = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.publisherTableToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.editToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.newToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.editToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.updateToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.undoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.deleteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.findPublisherToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.findByCodeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.findByNameToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.statusStripRecordCounter = new System.Windows.Forms.StatusStrip();
            this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
            this.toolStripPublisher = new System.Windows.Forms.ToolStrip();
            this.toolStripButtonFirst = new System.Windows.Forms.ToolStripButton();
            this.toolStripButtonPrevious = new System.Windows.Forms.ToolStripButton();
            this.toolStripButtonNext = new System.Windows.Forms.ToolStripButton();
            this.toolStripButtonLast = new System.Windows.Forms.ToolStripButton();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.textBoxPublisherCode = new System.Windows.Forms.TextBox();
            this.textBoxName = new System.Windows.Forms.TextBox();
            this.textBoxCity = new System.Windows.Forms.TextBox();
            this.menuStripPublisher.SuspendLayout();
            this.statusStripRecordCounter.SuspendLayout();
            this.toolStripPublisher.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(81, 79);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(108, 17);
            this.label1.TabIndex = 0;
            this.label1.Text = "Publisher Code:";
            // 
            // menuStripPublisher
            // 
            this.menuStripPublisher.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStripPublisher.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.editToolStripMenuItem,
            this.findPublisherToolStripMenuItem});
            this.menuStripPublisher.Location = new System.Drawing.Point(0, 0);
            this.menuStripPublisher.Name = "menuStripPublisher";
            this.menuStripPublisher.Padding = new System.Windows.Forms.Padding(5, 2, 0, 2);
            this.menuStripPublisher.Size = new System.Drawing.Size(469, 28);
            this.menuStripPublisher.TabIndex = 1;
            this.menuStripPublisher.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.publisherTableToolStripMenuItem,
            this.exitToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(44, 24);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // publisherTableToolStripMenuItem
            // 
            this.publisherTableToolStripMenuItem.Name = "publisherTableToolStripMenuItem";
            this.publisherTableToolStripMenuItem.Size = new System.Drawing.Size(183, 26);
            this.publisherTableToolStripMenuItem.Text = "Publisher Table";
            this.publisherTableToolStripMenuItem.Click += new System.EventHandler(this.booksByPublisherToolStripMenuItem_Click);
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.X)));
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(183, 26);
            this.exitToolStripMenuItem.Text = "Exit";
            this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click);
            // 
            // editToolStripMenuItem
            // 
            this.editToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.newToolStripMenuItem,
            this.editToolStripMenuItem1,
            this.updateToolStripMenuItem,
            this.undoToolStripMenuItem,
            this.deleteToolStripMenuItem});
            this.editToolStripMenuItem.Name = "editToolStripMenuItem";
            this.editToolStripMenuItem.Size = new System.Drawing.Size(47, 24);
            this.editToolStripMenuItem.Text = "Edit";
            // 
            // newToolStripMenuItem
            // 
            this.newToolStripMenuItem.Name = "newToolStripMenuItem";
            this.newToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.N)));
            this.newToolStripMenuItem.Size = new System.Drawing.Size(185, 26);
            this.newToolStripMenuItem.Text = "New";
            this.newToolStripMenuItem.Click += new System.EventHandler(this.newToolStripMenuItem_Click);
            // 
            // editToolStripMenuItem1
            // 
            this.editToolStripMenuItem1.Name = "editToolStripMenuItem1";
            this.editToolStripMenuItem1.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.E)));
            this.editToolStripMenuItem1.Size = new System.Drawing.Size(185, 26);
            this.editToolStripMenuItem1.Text = "Edit";
            this.editToolStripMenuItem1.Click += new System.EventHandler(this.editToolStripMenuItem1_Click);
            // 
            // updateToolStripMenuItem
            // 
            this.updateToolStripMenuItem.Name = "updateToolStripMenuItem";
            this.updateToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.U)));
            this.updateToolStripMenuItem.Size = new System.Drawing.Size(185, 26);
            this.updateToolStripMenuItem.Text = "Update";
            this.updateToolStripMenuItem.Click += new System.EventHandler(this.updateToolStripMenuItem_Click);
            // 
            // undoToolStripMenuItem
            // 
            this.undoToolStripMenuItem.Name = "undoToolStripMenuItem";
            this.undoToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.Z)));
            this.undoToolStripMenuItem.Size = new System.Drawing.Size(185, 26);
            this.undoToolStripMenuItem.Text = "Undo";
            this.undoToolStripMenuItem.Click += new System.EventHandler(this.undoToolStripMenuItem_Click);
            // 
            // deleteToolStripMenuItem
            // 
            this.deleteToolStripMenuItem.Name = "deleteToolStripMenuItem";
            this.deleteToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.D)));
            this.deleteToolStripMenuItem.Size = new System.Drawing.Size(185, 26);
            this.deleteToolStripMenuItem.Text = "Delete";
            this.deleteToolStripMenuItem.Click += new System.EventHandler(this.deleteToolStripMenuItem_Click);
            // 
            // findPublisherToolStripMenuItem
            // 
            this.findPublisherToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.findByCodeToolStripMenuItem,
            this.findByNameToolStripMenuItem});
            this.findPublisherToolStripMenuItem.Name = "findPublisherToolStripMenuItem";
            this.findPublisherToolStripMenuItem.Size = new System.Drawing.Size(113, 24);
            this.findPublisherToolStripMenuItem.Text = "Find Publisher";
            // 
            // findByCodeToolStripMenuItem
            // 
            this.findByCodeToolStripMenuItem.Name = "findByCodeToolStripMenuItem";
            this.findByCodeToolStripMenuItem.ShortcutKeys = System.Windows.Forms.Keys.F5;
            this.findByCodeToolStripMenuItem.Size = new System.Drawing.Size(229, 26);
            this.findByCodeToolStripMenuItem.Text = "Find by Code";
            this.findByCodeToolStripMenuItem.Click += new System.EventHandler(this.findByCodeToolStripMenuItem_Click);
            // 
            // findByNameToolStripMenuItem
            // 
            this.findByNameToolStripMenuItem.Name = "findByNameToolStripMenuItem";
            this.findByNameToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.F5)));
            this.findByNameToolStripMenuItem.Size = new System.Drawing.Size(229, 26);
            this.findByNameToolStripMenuItem.Text = "Find by Name";
            this.findByNameToolStripMenuItem.Click += new System.EventHandler(this.findByNameToolStripMenuItem_Click);
            // 
            // statusStripRecordCounter
            // 
            this.statusStripRecordCounter.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.statusStripRecordCounter.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel1});
            this.statusStripRecordCounter.Location = new System.Drawing.Point(0, 236);
            this.statusStripRecordCounter.Name = "statusStripRecordCounter";
            this.statusStripRecordCounter.Padding = new System.Windows.Forms.Padding(1, 0, 13, 0);
            this.statusStripRecordCounter.Size = new System.Drawing.Size(469, 25);
            this.statusStripRecordCounter.TabIndex = 2;
            this.statusStripRecordCounter.Text = "statusStrip1";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(151, 20);
            this.toolStripStatusLabel1.Text = "toolStripStatusLabel1";
            // 
            // toolStripPublisher
            // 
            this.toolStripPublisher.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.toolStripPublisher.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripButtonFirst,
            this.toolStripButtonPrevious,
            this.toolStripButtonNext,
            this.toolStripButtonLast});
            this.toolStripPublisher.Location = new System.Drawing.Point(0, 28);
            this.toolStripPublisher.Name = "toolStripPublisher";
            this.toolStripPublisher.Size = new System.Drawing.Size(469, 27);
            this.toolStripPublisher.TabIndex = 3;
            this.toolStripPublisher.Text = "toolStrip1";
            this.toolStripPublisher.ItemClicked += new System.Windows.Forms.ToolStripItemClickedEventHandler(this.toolStripPublisher_ItemClicked);
            // 
            // toolStripButtonFirst
            // 
            this.toolStripButtonFirst.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButtonFirst.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButtonFirst.Image")));
            this.toolStripButtonFirst.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButtonFirst.Name = "toolStripButtonFirst";
            this.toolStripButtonFirst.Size = new System.Drawing.Size(24, 24);
            this.toolStripButtonFirst.Text = "toolStripButton1";
            this.toolStripButtonFirst.ToolTipText = "First";
            // 
            // toolStripButtonPrevious
            // 
            this.toolStripButtonPrevious.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButtonPrevious.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButtonPrevious.Image")));
            this.toolStripButtonPrevious.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButtonPrevious.Name = "toolStripButtonPrevious";
            this.toolStripButtonPrevious.Size = new System.Drawing.Size(24, 24);
            this.toolStripButtonPrevious.Text = "toolStripButton1";
            this.toolStripButtonPrevious.ToolTipText = "Previous";
            // 
            // toolStripButtonNext
            // 
            this.toolStripButtonNext.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButtonNext.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButtonNext.Image")));
            this.toolStripButtonNext.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButtonNext.Name = "toolStripButtonNext";
            this.toolStripButtonNext.Size = new System.Drawing.Size(24, 24);
            this.toolStripButtonNext.Text = "toolStripButton1";
            this.toolStripButtonNext.ToolTipText = "Next";
            // 
            // toolStripButtonLast
            // 
            this.toolStripButtonLast.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButtonLast.Image = ((System.Drawing.Image)(resources.GetObject("toolStripButtonLast.Image")));
            this.toolStripButtonLast.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripButtonLast.Name = "toolStripButtonLast";
            this.toolStripButtonLast.Size = new System.Drawing.Size(24, 24);
            this.toolStripButtonLast.Text = "toolStripButton1";
            this.toolStripButtonLast.ToolTipText = "Last";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(81, 127);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 17);
            this.label2.TabIndex = 4;
            this.label2.Text = "Name:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(81, 175);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(35, 17);
            this.label3.TabIndex = 5;
            this.label3.Text = "City:";
            // 
            // textBoxPublisherCode
            // 
            this.textBoxPublisherCode.Location = new System.Drawing.Point(197, 73);
            this.textBoxPublisherCode.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.textBoxPublisherCode.Name = "textBoxPublisherCode";
            this.textBoxPublisherCode.Size = new System.Drawing.Size(176, 22);
            this.textBoxPublisherCode.TabIndex = 6;
            // 
            // textBoxName
            // 
            this.textBoxName.Location = new System.Drawing.Point(197, 122);
            this.textBoxName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.textBoxName.Name = "textBoxName";
            this.textBoxName.Size = new System.Drawing.Size(176, 22);
            this.textBoxName.TabIndex = 7;
            // 
            // textBoxCity
            // 
            this.textBoxCity.Location = new System.Drawing.Point(197, 169);
            this.textBoxCity.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.textBoxCity.Name = "textBoxCity";
            this.textBoxCity.Size = new System.Drawing.Size(176, 22);
            this.textBoxCity.TabIndex = 8;
            // 
            // Publisher
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(469, 261);
            this.Controls.Add(this.textBoxCity);
            this.Controls.Add(this.textBoxName);
            this.Controls.Add(this.textBoxPublisherCode);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.toolStripPublisher);
            this.Controls.Add(this.statusStripRecordCounter);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.menuStripPublisher);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MainMenuStrip = this.menuStripPublisher;
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.MaximizeBox = false;
            this.Name = "Publisher";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Publisher Table";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form_Closing);
            this.Load += new System.EventHandler(this.Form1_Load);
            this.menuStripPublisher.ResumeLayout(false);
            this.menuStripPublisher.PerformLayout();
            this.statusStripRecordCounter.ResumeLayout(false);
            this.statusStripRecordCounter.PerformLayout();
            this.toolStripPublisher.ResumeLayout(false);
            this.toolStripPublisher.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.MenuStrip menuStripPublisher;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem publisherTableToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem editToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem newToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem editToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem updateToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem undoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem deleteToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem findPublisherToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem findByCodeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem findByNameToolStripMenuItem;
        private System.Windows.Forms.StatusStrip statusStripRecordCounter;
        private System.Windows.Forms.ToolStrip toolStripPublisher;
        private System.Windows.Forms.ToolStripButton toolStripButtonFirst;
        private System.Windows.Forms.ToolStripButton toolStripButtonPrevious;
        private System.Windows.Forms.ToolStripButton toolStripButtonNext;
        private System.Windows.Forms.ToolStripButton toolStripButtonLast;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textBoxPublisherCode;
        private System.Windows.Forms.TextBox textBoxName;
        private System.Windows.Forms.TextBox textBoxCity;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
    }
}

