﻿namespace WindowsFormsDatabase1
{
    partial class FindPublisherByCode
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cancelToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxFindPublisherCode = new System.Windows.Forms.TextBox();
            this.buttonFindPublisherCode = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(351, 28);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.cancelToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(44, 24);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // cancelToolStripMenuItem
            // 
            this.cancelToolStripMenuItem.Name = "cancelToolStripMenuItem";
            this.cancelToolStripMenuItem.Size = new System.Drawing.Size(128, 26);
            this.cancelToolStripMenuItem.Text = "Cancel";
            this.cancelToolStripMenuItem.Click += new System.EventHandler(this.cancelToolStripMenuItem_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(50, 54);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(250, 18);
            this.label1.TabIndex = 1;
            this.label1.Text = "Enter publisher code and click button";
            // 
            // textBoxFindPublisherCode
            // 
            this.textBoxFindPublisherCode.Location = new System.Drawing.Point(125, 91);
            this.textBoxFindPublisherCode.MaxLength = 2;
            this.textBoxFindPublisherCode.Name = "textBoxFindPublisherCode";
            this.textBoxFindPublisherCode.Size = new System.Drawing.Size(100, 22);
            this.textBoxFindPublisherCode.TabIndex = 2;
            this.textBoxFindPublisherCode.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // buttonFindPublisherCode
            // 
            this.buttonFindPublisherCode.Location = new System.Drawing.Point(138, 146);
            this.buttonFindPublisherCode.Name = "buttonFindPublisherCode";
            this.buttonFindPublisherCode.Size = new System.Drawing.Size(75, 31);
            this.buttonFindPublisherCode.TabIndex = 3;
            this.buttonFindPublisherCode.Text = "Find";
            this.buttonFindPublisherCode.UseVisualStyleBackColor = true;
            this.buttonFindPublisherCode.Click += new System.EventHandler(this.buttonFindPublisherCode_Click);
            // 
            // FindPublisherByCode
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(351, 224);
            this.Controls.Add(this.buttonFindPublisherCode);
            this.Controls.Add(this.textBoxFindPublisherCode);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "FindPublisherByCode";
            this.Load += new System.EventHandler(this.FindPublisherByCode_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem cancelToolStripMenuItem;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxFindPublisherCode;
        private System.Windows.Forms.Button buttonFindPublisherCode;
    }
}