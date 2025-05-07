package Display;

import Interface.gather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class display extends JPanel
{
    private JPanel displayPanel;
    private JPanel buttonPanel;
    private gather[][] tempGather;
    private JFrame frame;
    private JButton exitButton;
    private JButton playButton;
    private JButton stopButton;

    public display()
    {
        //创建对象
        displayPanel = new JPanel();
        buttonPanel = new JPanel(new FlowLayout());
        exitButton = new JButton("Exit");
        playButton = new JButton("Play");
        stopButton = new JButton("Stop");

        //设置
        frame = new JFrame("Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.add(buttonPanel,BorderLayout.NORTH);     //把按钮的面板添加到frame中
        this.setPreferredSize(new Dimension(800,800));

        buttonPanel.add(playButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(stopButton);

        //按钮点击事件
        //TODO:需要补充按钮点击事件
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.add(this);
        //frame.add(button);
        frame.pack();

        tempGather = new gather[50][50];
    }

    public void set()
    {

    }

    //由data部分告诉display要画什么东西出来，保证了两个类不会有太多的联系
    public void setArray(int x,int y,gather item)
    {
        tempGather[x][y] = item;
        repaint();
    }

    //重写函数
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //设置背景颜色和网格颜色
        setBackground(Color.white);
        g.setColor(Color.gray);

        //网格的行数，网格自适应大小
        int width = getWidth();
        int height = getHeight();
        int cellWidth = width / tempGather[0].length;
        int cellHeight = height / tempGather.length;
        int gridSize = Math.min(cellWidth, cellHeight);

        //网格的行数和列数
        int rows = tempGather.length;
        int cols = tempGather[0].length;

        //绘画网格
        for(int i=0;i<rows;i++)
        {
            g.drawLine(0,i*gridSize,cols*gridSize,i*gridSize);
        }

        for(int j=0;j<cols;j++)
        {
            g.drawLine(j*gridSize,0,j*gridSize,rows*gridSize);
        }
    }
}
