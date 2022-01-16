Global DisableConsoleOpening% = GetINIInt("options.ini", "console", "disable opening")

Global ReplaceIMG%,ReplaceTexture%

Global ErrorAmount% = 0

Function LoadMissingTextures()
	
	ReplaceIMG% = CreateImage(128,128)
	SetBuffer ImageBuffer(ReplaceImg%)
	Color 1,1,1
	Rect 0,0,32,32
	Rect 32,32,32,32
	Rect 64,64,32,32
	Rect 96,96,32,32
	Rect 0,64,32,32
	Rect 64,0,32,32
	Rect 32,96,32,32
	Rect 96,32,32,32
	Color 255,0,255
	Rect 0,32,32,32
	Rect 32,0,32,32
	Rect 32,64,32,32
	Rect 64,32,32,32
	Rect 64,96,32,32
	Rect 96,64,32,32
	Rect 0,96,32,32
	Rect 96,0,32,32
	SetBuffer BackBuffer()
	
	ReplaceTexture% = CreateTexture(128,128)
	SetBuffer TextureBuffer(ReplaceTexture%)
	ClsColor 255,255,255
	Cls
	Color 1,1,1
	Rect 0,0,32,32
	Rect 32,32,32,32
	Rect 64,64,32,32
	Rect 96,96,32,32
	Rect 0,64,32,32
	Rect 64,0,32,32
	Rect 32,96,32,32
	Rect 96,32,32,32
	Color 255,0,255
	Rect 0,32,32,32
	Rect 32,0,32,32
	Rect 32,64,32,32
	Rect 64,32,32,32
	Rect 64,96,32,32
	Rect 96,64,32,32
	Rect 0,96,32,32
	Rect 96,0,32,32
	SetBuffer BackBuffer()
	
End Function

Function FindError()
	
	If (Not DisableConsoleOpening%) Then Return
	
	If ErrorAmount%>0
		SetFont Font1%
		Color 255,0,0
		Text 0,0,ErrorAmount+" new Errors found: See Console for details"
	EndIf
	
	If ConsoleOpen Then ErrorAmount% = 0
	
End Function

