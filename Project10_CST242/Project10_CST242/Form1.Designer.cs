namespace Project10_CST242
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
            this.textBoxName = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxLoanAmount = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.textBoxInterestRate = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.groupBoxNumOfYrs = new System.Windows.Forms.GroupBox();
            this.radioButton15Yrs = new System.Windows.Forms.RadioButton();
            this.radioButton10Yrs = new System.Windows.Forms.RadioButton();
            this.radioButton5Yrs = new System.Windows.Forms.RadioButton();
            this.listBoxMonthlyPayment = new System.Windows.Forms.ListBox();
            this.buttonGetMonthlyPayment = new System.Windows.Forms.Button();
            this.buttonClear = new System.Windows.Forms.Button();
            this.groupBoxNumOfYrs.SuspendLayout();
            this.SuspendLayout();
            // 
            // textBoxName
            // 
            this.textBoxName.Location = new System.Drawing.Point(67, 28);
            this.textBoxName.Name = "textBoxName";
            this.textBoxName.Size = new System.Drawing.Size(100, 20);
            this.textBoxName.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(64, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(57, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Full Name:";
            // 
            // textBoxLoanAmount
            // 
            this.textBoxLoanAmount.Location = new System.Drawing.Point(67, 96);
            this.textBoxLoanAmount.Name = "textBoxLoanAmount";
            this.textBoxLoanAmount.Size = new System.Drawing.Size(100, 20);
            this.textBoxLoanAmount.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(67, 77);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(73, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Loan Amount:";
            // 
            // textBoxInterestRate
            // 
            this.textBoxInterestRate.Location = new System.Drawing.Point(67, 156);
            this.textBoxInterestRate.Name = "textBoxInterestRate";
            this.textBoxInterestRate.Size = new System.Drawing.Size(100, 20);
            this.textBoxInterestRate.TabIndex = 4;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(67, 137);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(59, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Interest(%):";
            // 
            // groupBoxNumOfYrs
            // 
            this.groupBoxNumOfYrs.Controls.Add(this.radioButton15Yrs);
            this.groupBoxNumOfYrs.Controls.Add(this.radioButton10Yrs);
            this.groupBoxNumOfYrs.Controls.Add(this.radioButton5Yrs);
            this.groupBoxNumOfYrs.Location = new System.Drawing.Point(22, 204);
            this.groupBoxNumOfYrs.Name = "groupBoxNumOfYrs";
            this.groupBoxNumOfYrs.Size = new System.Drawing.Size(200, 100);
            this.groupBoxNumOfYrs.TabIndex = 6;
            this.groupBoxNumOfYrs.TabStop = false;
            this.groupBoxNumOfYrs.Text = "Number Of Years";
            // 
            // radioButton15Yrs
            // 
            this.radioButton15Yrs.AutoSize = true;
            this.radioButton15Yrs.Location = new System.Drawing.Point(6, 66);
            this.radioButton15Yrs.Name = "radioButton15Yrs";
            this.radioButton15Yrs.Size = new System.Drawing.Size(67, 17);
            this.radioButton15Yrs.TabIndex = 2;
            this.radioButton15Yrs.TabStop = true;
            this.radioButton15Yrs.Text = "15 Years";
            this.radioButton15Yrs.UseVisualStyleBackColor = true;
            // 
            // radioButton10Yrs
            // 
            this.radioButton10Yrs.AutoSize = true;
            this.radioButton10Yrs.Location = new System.Drawing.Point(6, 43);
            this.radioButton10Yrs.Name = "radioButton10Yrs";
            this.radioButton10Yrs.Size = new System.Drawing.Size(67, 17);
            this.radioButton10Yrs.TabIndex = 1;
            this.radioButton10Yrs.TabStop = true;
            this.radioButton10Yrs.Text = "10 Years";
            this.radioButton10Yrs.UseVisualStyleBackColor = true;
            // 
            // radioButton5Yrs
            // 
            this.radioButton5Yrs.AutoSize = true;
            this.radioButton5Yrs.Location = new System.Drawing.Point(7, 20);
            this.radioButton5Yrs.Name = "radioButton5Yrs";
            this.radioButton5Yrs.Size = new System.Drawing.Size(61, 17);
            this.radioButton5Yrs.TabIndex = 0;
            this.radioButton5Yrs.TabStop = true;
            this.radioButton5Yrs.Text = "5 Years";
            this.radioButton5Yrs.UseVisualStyleBackColor = true;
            // 
            // listBoxMonthlyPayment
            // 
            this.listBoxMonthlyPayment.FormattingEnabled = true;
            this.listBoxMonthlyPayment.Location = new System.Drawing.Point(1, 379);
            this.listBoxMonthlyPayment.Name = "listBoxMonthlyPayment";
            this.listBoxMonthlyPayment.Size = new System.Drawing.Size(260, 121);
            this.listBoxMonthlyPayment.TabIndex = 7;
            // 
            // buttonGetMonthlyPayment
            // 
            this.buttonGetMonthlyPayment.Location = new System.Drawing.Point(22, 310);
            this.buttonGetMonthlyPayment.Name = "buttonGetMonthlyPayment";
            this.buttonGetMonthlyPayment.Size = new System.Drawing.Size(200, 23);
            this.buttonGetMonthlyPayment.TabIndex = 8;
            this.buttonGetMonthlyPayment.Text = "Calculate Monthly Payment";
            this.buttonGetMonthlyPayment.UseVisualStyleBackColor = true;
            this.buttonGetMonthlyPayment.Click += new System.EventHandler(this.buttonGetMonthlyPayment_Click);
            // 
            // buttonClear
            // 
            this.buttonClear.Location = new System.Drawing.Point(22, 340);
            this.buttonClear.Name = "buttonClear";
            this.buttonClear.Size = new System.Drawing.Size(200, 23);
            this.buttonClear.TabIndex = 9;
            this.buttonClear.Text = "Clear Form";
            this.buttonClear.UseVisualStyleBackColor = true;
            this.buttonClear.Click += new System.EventHandler(this.buttonClear_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(260, 501);
            this.Controls.Add(this.buttonClear);
            this.Controls.Add(this.buttonGetMonthlyPayment);
            this.Controls.Add(this.listBoxMonthlyPayment);
            this.Controls.Add(this.groupBoxNumOfYrs);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.textBoxInterestRate);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.textBoxLoanAmount);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBoxName);
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.Text = "Loan Calculator";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBoxNumOfYrs.ResumeLayout(false);
            this.groupBoxNumOfYrs.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxName;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxLoanAmount;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBoxInterestRate;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.GroupBox groupBoxNumOfYrs;
        private System.Windows.Forms.RadioButton radioButton15Yrs;
        private System.Windows.Forms.RadioButton radioButton10Yrs;
        private System.Windows.Forms.RadioButton radioButton5Yrs;
        private System.Windows.Forms.ListBox listBoxMonthlyPayment;
        private System.Windows.Forms.Button buttonGetMonthlyPayment;
        private System.Windows.Forms.Button buttonClear;
    }
}

