
/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener {

    // Fields to hold the UI elements

    private lateinit var redJTextField: JTextField
    private lateinit var greenJTextField: JTextField
    private lateinit var blueJTextField: JTextField

    private lateinit var redUpButton: JButton
    private lateinit var redDownButton: JButton

    private lateinit var greenUpButton: JButton
    private lateinit var greenDownButton: JButton

    private lateinit var blueUpButton: JButton
    private lateinit var blueDownButton: JButton

    private lateinit var rLabel: JLabel
    private lateinit var gLabel: JLabel
    private lateinit var bLabel: JLabel

    private lateinit var colourHEX: JLabel

    private lateinit var colourPanel: JPanel


    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin color picker"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 30)
        val bigFont = Font(Font.SANS_SERIF, Font.PLAIN, 50)

        redUpButton = JButton("↑")
        redUpButton.horizontalAlignment = SwingConstants.CENTER
        redUpButton.bounds = Rectangle(90, 60, 30, 30)
        redUpButton.background = Color(255, 0, 0)
        redUpButton.font = defaultFont
        redUpButton.addActionListener(this)
        add(redUpButton)

        greenUpButton = JButton("↑")
        greenUpButton.bounds = Rectangle(90, 130, 30, 30)
        greenUpButton.font = defaultFont
        greenUpButton.background = Color(0, 255, 0)
        greenUpButton.addActionListener(this)      // Handle any clicks
        add(greenUpButton)

        blueUpButton = JButton("↑")
        blueUpButton.bounds = Rectangle(90, 200, 30, 30)
        blueUpButton.font = defaultFont
        blueUpButton.background = Color(0, 0, 255)
        blueUpButton.addActionListener(this)      // Handle any clicks
        add(blueUpButton)

        redDownButton = JButton("↓")
        redDownButton.horizontalAlignment = SwingConstants.CENTER
        redDownButton.bounds = Rectangle(90, 90, 30, 30)
        redDownButton.background = Color(255, 0, 0)
        redDownButton.font = defaultFont
        add(redDownButton)

        greenDownButton = JButton("↓")
        greenDownButton.horizontalAlignment = SwingConstants.CENTER
        greenDownButton.bounds = Rectangle(90, 160, 30, 30)
        greenDownButton.background = Color(0, 255, 0)
        greenDownButton.font = defaultFont
        add(greenDownButton)

        blueDownButton = JButton("↓")
        blueDownButton.horizontalAlignment = SwingConstants.CENTER
        blueDownButton.bounds = Rectangle(90, 230, 30, 30)
        blueDownButton.background = Color(0, 0, 255)
        blueDownButton.font = defaultFont
        add(blueDownButton)

        // --------------------------------------------------

        redJTextField = JTextField("000")
        redJTextField.horizontalAlignment = SwingConstants.CENTER
        redJTextField.bounds = Rectangle(120, 60, 70, 60)
        redJTextField.background = Color(255, 0, 0)
        redJTextField.font = defaultFont
        add(redJTextField)

        greenJTextField = JTextField("000")
        greenJTextField.horizontalAlignment = SwingConstants.CENTER
        greenJTextField.bounds = Rectangle(120, 130, 70, 60)
        greenJTextField.background = Color(0, 255, 0)
        greenJTextField.font = defaultFont
        add(greenJTextField)

        blueJTextField = JTextField("000")
        blueJTextField.horizontalAlignment = SwingConstants.CENTER
        blueJTextField.bounds = Rectangle(120, 200, 70, 60)
        blueJTextField.background = Color(0, 0, 255)
        blueJTextField.font = defaultFont
        add(blueJTextField)

        // --------------------------------------------------

        rLabel = JLabel("R")
        rLabel.horizontalAlignment = SwingConstants.CENTER
        rLabel.bounds = Rectangle(30, 60, 50, 60)
        rLabel.foreground = Color(255, 0, 0)
        rLabel.font = bigFont
        add(rLabel)

        gLabel = JLabel("G")
        gLabel.horizontalAlignment = SwingConstants.CENTER
        gLabel.bounds = Rectangle(30, 130, 50, 60)
        gLabel.foreground = Color(0, 255, 0)
        gLabel.font = bigFont
        add(gLabel)

        bLabel = JLabel("B")
        bLabel.horizontalAlignment = SwingConstants.CENTER
        bLabel.bounds = Rectangle(30, 200, 50, 60)
        bLabel.foreground = Color(0, 0, 255)
        bLabel.font = bigFont
        add(bLabel)

        colourHEX = JLabel("#000000")
        colourHEX.bounds = Rectangle(250, 110, 250, 250)
        colourHEX.horizontalAlignment = SwingConstants.CENTER
        colourHEX.foreground = Color(255, 225, 255)
        colourHEX.font = bigFont
        add(colourHEX)

        // -----------------------------------------------------

        colourPanel = JPanel()
        colourPanel.bounds = Rectangle(250, 110, 250, 250)
        colourPanel.background = Color.WHITE
        add(colourPanel)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        var red = redJTextField.text.toInt()
        var green = greenJTextField.text.toInt()
        var blue = blueJTextField.text.toInt()

        when (e?.source) {
            redUpButton -> {
                red++
                when (e.source) {
                    redDownButton -> {
                        red--
                    }

                    when (e.source) {
                        greenUpButton -> {
                            green++
                        }

                        when (e.source) {
                            greenDownButton -> {
                                green--
                                when (e.source) {
                                    blueUpButton -> {
                                        blue++
                                        when (e.source) {
                                            blueDownButton -> {
                                                blue--
                                            }
                                        }
                                    }
                                }

                                redJTextField.text = red.toString()
                                greenJTextField.text = green.toString()
                                blueJTextField.text = blue.toString()

                                updateUI()
                            }

                            fun updateUI() {
                                var red = redJTextField.text.toInt()
                                var green = greenJTextField.text.toInt()
                                var blue = blueJTextField.text.toInt()

                                colourPanel.background = Color(red, green, blue)
                            }
                        }
                    }
                }
            }
        }
    }
}
