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
            this.label2 = new System.Windows.Forms.Label();
            this.textBoxName = new System.Windows.Forms.TextBox();
            this.textBoxAge = new System.Windows.Forms.TextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.radioButtonFemale = new System.Windows.Forms.RadioButton();
            this.radioButtonMale = new System.Windows.Forms.RadioButton();
            this.checkBoxNonSmoker = new System.Windows.Forms.CheckBox();
            this.comboBoxRegion = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.listBoxQuote = new System.Windows.Forms.ListBox();
            this.buttonGetQuote = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(28, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(82, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Customer Name";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(28, 87);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(26, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Age";
            // 
            // textBoxName
            // 
            this.textBoxName.Location = new System.Drawing.Point(31, 45);
            this.textBoxName.Name = "textBoxName";
            this.textBoxName.Size = new System.Drawing.Size(100, 20);
            this.textBoxName.TabIndex = 2;
            // 
            // textBoxAge
            // 
            this.textBoxAge.Location = new System.Drawing.Point(31, 103);
            this.textBoxAge.Name = "textBoxAge";
            this.textBoxAge.Size = new System.Drawing.Size(100, 20);
            this.textBoxAge.TabIndex = 3;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radioButtonMale);
            this.groupBox1.Controls.Add(this.radioButtonFemale);
            this.groupBox1.Location = new System.Drawing.Point(31, 145);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(174, 100);
            this.groupBox1.TabIndex = 4;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Gender";
            // 
            // radioButtonFemale
            // 
            this.radioButtonFemale.AutoSize = true;
            this.radioButtonFemale.Location = new System.Drawing.Point(7, 20);
            this.radioButtonFemale.Name = "radioButtonFemale";
            this.radioButtonFemale.Size = new System.Drawing.Size(59, 17);
            this.radioButtonFemale.TabIndex = 0;
            this.radioButtonFemale.TabStop = true;
            this.radioButtonFemale.Text = "Female";
            this.radioButtonFemale.UseVisualStyleBackColor = true;
            // 
            // radioButtonMale
            // 
            this.radioButtonMale.AutoSize = true;
            this.radioButtonMale.Location = new System.Drawing.Point(7, 52);
            this.radioButtonMale.Name = "radioButtonMale";
            this.radioButtonMale.Size = new System.Drawing.Size(48, 17);
            this.radioButtonMale.TabIndex = 1;
            this.radioButtonMale.TabStop = true;
            this.radioButtonMale.Text = "Male";
            this.radioButtonMale.UseVisualStyleBackColor = true;
            // 
            // checkBoxNonSmoker
            // 
            this.checkBoxNonSmoker.AutoSize = true;
            this.checkBoxNonSmoker.Location = new System.Drawing.Point(51, 269);
            this.checkBoxNonSmoker.Name = "checkBoxNonSmoker";
            this.checkBoxNonSmoker.Size = new System.Drawing.Size(132, 17);
            this.checkBoxNonSmoker.TabIndex = 5;
            this.checkBoxNonSmoker.Text = "Non-smoker discount?";
            this.checkBoxNonSmoker.UseVisualStyleBackColor = true;
            // 
            // comboBoxRegion
            // 
            this.comboBoxRegion.FormattingEnabled = true;
            this.comboBoxRegion.Items.AddRange(new object[] {
            "",
            "East",
            "Central",
            "South",
            "West"});
            this.comboBoxRegion.Location = new System.Drawing.Point(38, 325);
            this.comboBoxRegion.Name = "comboBoxRegion";
            this.comboBoxRegion.Size = new System.Drawing.Size(152, 21);
            this.comboBoxRegion.TabIndex = 6;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(35, 309);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(134, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Where Does Insured Live?";
            // 
            // listBoxQuote
            // 
            this.listBoxQuote.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.listBoxQuote.FormattingEnabled = true;
            this.listBoxQuote.Location = new System.Drawing.Point(0, 429);
            this.listBoxQuote.Name = "listBoxQuote";
            this.listBoxQuote.Size = new System.Drawing.Size(284, 95);
            this.listBoxQuote.TabIndex = 8;
            // 
            // buttonGetQuote
            // 
            this.buttonGetQuote.Location = new System.Drawing.Point(71, 371);
            this.buttonGetQuote.Name = "buttonGetQuote";
            this.buttonGetQuote.Size = new System.Drawing.Size(87, 23);
            this.buttonGetQuote.TabIndex = 9;
            this.buttonGetQuote.Text = "Get Quote";
            this.buttonGetQuote.UseVisualStyleBackColor = true;
            this.buttonGetQuote.Click += new System.EventHandler(this.buttonGetQuote_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 524);
            this.Controls.Add(this.buttonGetQuote);
            this.Controls.Add(this.listBoxQuote);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.comboBoxRegion);
            this.Controls.Add(this.checkBoxNonSmoker);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.textBoxAge);
            this.Controls.Add(this.textBoxName);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBoxName;
        private System.Windows.Forms.TextBox textBoxAge;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton radioButtonMale;
        private System.Windows.Forms.RadioButton radioButtonFemale;
        private System.Windows.Forms.CheckBox checkBoxNonSmoker;
        private System.Windows.Forms.ComboBox comboBoxRegion;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ListBox listBoxQuote;
        private System.Windows.Forms.Button buttonGetQuote;
    }
}

