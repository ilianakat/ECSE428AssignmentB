#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.5
 Author:         Marine Huynh

 Script Function:
	upload a file to send

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
$count = 0

While $count <> 10
   $hdl = WinActivate("Open")

   If $hdl <> 0 Then
	  ControlFocus("Open", "", "Edit1")
	  Sleep(500)
	  ControlSetText("Open", "", "Edit1", "C:\Users\Marine\AI\ECSE428AssignmentB\attachments\smallImage.jpg")
	  Sleep(500)
	  ControlClick("Open", "", "Button1")
	  Exit
	  ElseIf


   Sleep(1000)
   $count = $count + 1

   WEnd