namespace WindowsForms1
{
    partial class Form1
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
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxName = new System.Windows.Forms.TextBox();
            this.buttonGetQuote = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.textBoxAge = new System.Windows.Forms.TextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.radioButtonMale = new System.Windows.Forms.RadioButton();
            this.radioButtonFemale = new System.Windows.Forms.RadioButton();
            this.checkBoxNonSmoker = new System.Windows.Forms.CheckBox();
            this.listBoxQuote = new System.Windows.Forms.ListBox();
            this.comboBoxRegion = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(86, 14);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(113, 17);
            this.label1.TabIndex = 0;
            this.label1.Text = "Customer Name:";
            // 
            // textBoxName
            // 
            this.textBoxName.Location = new System.Drawing.Point(86, 34);
            this.textBoxName.Name = "textBoxName";
            this.textBoxName.Size = new System.Drawing.Size(168, 22);
            this.textBoxName.TabIndex = 0;
            // 
            // buttonGetQuote
            // 
            this.buttonGetQuote.Location = new System.Drawing.Point(129, 352);
            this.buttonGetQuote.Name = "buttonGetQuote";
            this.buttonGetQuote.Size = new System.Drawing.Size(89, 36);
            this.buttonGetQuote.TabIndex = 5;
            this.buttonGetQuote.Text = "Get Quote";
            this.buttonGetQuote.UseVisualStyleBackColor = true;
            this.buttonGetQuote.Click += new System.EventHandler(this.buttonGetQuote_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(86, 68);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(37, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "Age:";
            // 
            // textBoxAge
            // 
            this.textBoxAge.Location = new System.Drawing.Point(86, 88);
            this.textBoxAge.Name = "textBoxAge";
            this.textBoxAge.Size = new System.Drawing.Size(168, 22);
            this.textBoxAge.TabIndex = 1;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radioButtonMale);
            this.groupBox1.Controls.Add(this.radioButtonFemale);
            this.groupBox1.Location = new System.Drawing.Point(86, 133);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(168, 82);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Gender";
            // 
            // radioButtonMale
            // 
            this.radioButtonMale.AutoSize = true;
            this.radioButtonMale.Location = new System.Drawing.Point(36, 49);
            this.radioButtonMale.Name = "radioButtonMale";
            this.radioButtonMale.Size = new System.Drawing.Size(59, 21);
            this.radioButtonMale.TabIndex = 1;
            this.radioButtonMale.TabStop = true;
            this.radioButtonMale.Text = "Male";
            this.radioButtonMale.UseVisualStyleBackColor = true;
            // 
            // radioButtonFemale
            // 
            this.radioButtonFemale.AutoSize = true;
            this.radioButtonFemale.Location = new System.Drawing.Point(36, 22);
            this.radioButtonFemale.Name = "radioButtonFemale";
            this.radioButtonFemale.Size = new System.Drawing.Size(75, 21);
            this.radioButtonFemale.TabIndex = 0;
            this.radioButtonFemale.TabStop = true;
            this.radioButtonFemale.Text = "Female";
            this.radioButtonFemale.UseVisualStyleBackColor = true;
            // 
            // checkBoxNonSmoker
            // 
            this.checkBoxNonSmoker.AutoSize = true;
            this.checkBoxNonSmoker.Location = new System.Drawing.Point(89, 234);
            this.checkBoxNonSmoker.Name = "checkBoxNonSmoker";
            this.checkBoxNonSmoker.Size = new System.Drawing.Size(172, 21);
            this.checkBoxNonSmoker.TabIndex = 3;
            this.checkBoxNonSmoker.Text = "Non-smoker discount?";
            this.checkBoxNonSmoker.UseVisualStyleBackColor = true;
            // 
            // listBoxQuote
            // 
            this.listBoxQuote.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.listBoxQuote.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBoxQuote.FormattingEnabled = true;
            this.listBoxQuote.ItemHeight = 20;
            this.listBoxQuote.Location = new System.Drawing.Point(0, 418);
            this.listBoxQuote.Name = "listBoxQuote";
            this.listBoxQuote.Size = new System.Drawing.Size(347, 124);
            this.listBoxQuote.TabIndex = 6;
            // 
            // comboBoxRegion
            // 
            this.comboBoxRegion.FormattingEnabled = true;
            this.comboBoxRegion.Items.AddRange(new object[] {
            "",
            "East",
            "South",
            "Central",
            "West"});
            this.comboBoxRegion.Location = new System.Drawing.Point(86, 300);
            this.comboBoxRegion.Name = "comboBoxRegion";
            this.comboBoxRegion.Size = new System.Drawing.Size(168, 24);
            this.comboBoxRegion.TabIndex = 4;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(86, 280);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(169, 17);
            this.label3.TabIndex = 9;
            this.label3.Text = "Where does insured live?";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(347, 542);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.comboBoxRegion);
            this.Controls.Add(this.listBoxQuote);
            this.Controls.Add(this.checkBoxNonSmoker);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.textBoxAge);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.buttonGetQuote);
            this.Controls.Add(this.textBoxName);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Insurance Quote";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxName;
        private System.Windows.Forms.Button buttonGetQuote;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBoxAge;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton radioButtonMale;
        private System.Windows.Forms.RadioButton radioButtonFemale;
        private System.Windows.Forms.CheckBox checkBoxNonSmoker;
        private System.Windows.Forms.ListBox listBoxQuote;
        private System.Windows.Forms.ComboBox comboBoxRegion;
        private System.Windows.Forms.Label label3;
    }
}

