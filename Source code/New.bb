
Dim ChatSFX(9,9)

Dim MTF2SFX%(8)

Global ChatSFXCHN
Global KEY_CHAT = GetINIInt("NineTailedFoxMod\options.ini", "options", "chat key")
Global ChatSFXOpened% = False
Global ChatSFXOpenedTimer# = 0.0
Global ChatSFXOpenedColor% = 255
Global ChatSFXOpenedColorFloat# = 255.0
Global ChatSFX_On, ChatSFX_Off
Global ChatSFX_CurrSound

Global MTF_PlayerViewModel,MTF_PlayerViewModelPVT

Global BloodSpitSprite1,BloodSpitSprite2

Global NTF_InfiniteStamina% = False

Global NTF_DisableConsoleOpening% = GetINIInt("NineTailedFoxMod\options.ini", "console", "disable opening")

Global MTFObj2,D035Obj,NaziObj,ZombieObj,ClassDObj2,B457Obj,N966Obj

Dim NTF_PainSFX(8)
Dim NTF_PainWeakSFX(2)

Global NTF_1MaxAmbient% = 5
Global NTF_2MaxAmbient% = 3
Global NTF_3MaxAmbient% = 3
Global NTF_4MaxAmbient% = 7
Global NTF_5MaxAmbient% = 4
Global NTF_6MaxAmbient% = 4
Global NTF_7MaxAmbient% = 3
Global NTF_8MaxAmbient% = 5
Global NTF_9MaxAmbient% = 5
Global NTF_10MaxAmbient% = 4
Global NTF_11MaxAmbient% = 3
Global NTF_12MaxAmbient% = 3
Global NTF_13MaxAmbient% = 4
Global NTF_14MaxAmbient% = 5
Global NTF_15MaxAmbient% = 3

Global NTF_MaxAmbientSFX% = 39

Dim NTF_AmbientSFX(16,NTF_MaxAmbientSFX%)

Global NTF_DisableAimCross% = GetINIInt("NineTailedFoxMod\options.ini", "options", "disable aim cross")

Dim NTF_BodyTextures(2)

Global ReplaceIMG%,ReplaceTexture%

Global NTF_ErrorAmount% = 0

Global NTF_457Death

Global flame01,Ash

Global NTF_457Flame

Global NTF_RadioCHN
Global KEY_RADIOTOGGLE = GetINIInt("NineTailedFoxMod\options.ini", "options", "radiotoggle key")

Global NTF_BrokenDoorSFX

Global NTF_1499Sky

Const NTF_Achv457% = 35
Const NTF_Achv1162% = 36
Const NTF_AchvMassage% = 37
Const NTF_AchvTeam% = 38
Const NTF_AchvReal% = 39
Const NTF_AchvRage% = 40
Const NTF_AchvContain173% = 41

Global NTF_Wearing1499%
Global NTF_1499PrevX#
Global NTF_1499PrevY#
Global NTF_1499PrevZ#
Global NTF_1499PrevRoom$
Global NTF_1499X#
Global NTF_1499Y#
Global NTF_1499Z#
Global NTF_PrevPlayerRoom$

Global NTF_1499EnterSFX%, NTF_1499LeaveSFX%

Dim NTF_RadioSFX1(5)
Dim NTF_RadioSFX2(11)

Dim NTF_BloodOverlay(2,2)

Global NTF_AmbienceSFX
Global NTF_AmbienceCHN
Dim NTF_AmbienceStrings$(106)
NTF_AmbienceStrings$(0) = "brief_encounter.ogg"
NTF_AmbienceStrings$(1) = "friendly_fire.ogg"
NTF_AmbienceStrings$(2) = "int_bursts.ogg"
NTF_AmbienceStrings$(3) = "panic.ogg"
NTF_AmbienceStrings$(4) = "indoor_camera_generic_underground_jolt1.ogg"
NTF_AmbienceStrings$(5) = "indoor_camera_generic_underground_tremor_high1.ogg"
NTF_AmbienceStrings$(6) = "indoor_dist_generic_door_kick1.ogg"
NTF_AmbienceStrings$(7) = "indoor_dist_generic_gunfire_chaotic_pistol1.ogg"
NTF_AmbienceStrings$(8) = "indoor_dist_generic_gunfire_sustained_pistol1.ogg"
NTF_AmbienceStrings$(9) = "indoor_dist_generic_gunfire_sustained_smg1.ogg"
NTF_AmbienceStrings$(10) = "indoor_dist_generic_metal_break1.ogg"
NTF_AmbienceStrings$(11) = "indoor_dist_generic_metal_scrape1.ogg"
NTF_AmbienceStrings$(12) = "indoor_dist_generic_metal_scrape2.ogg"
NTF_AmbienceStrings$(13) = "indoor_dist_generic_metal_stress1.ogg"
NTF_AmbienceStrings$(14) = "indoor_dist_generic_metal_stress2.ogg"
NTF_AmbienceStrings$(15) = "indoor_dist_generic_metaldoor_kick1.ogg"
NTF_AmbienceStrings$(16) = "indoor_far_generic_groan1.ogg"
NTF_AmbienceStrings$(17) = "indoor_far_generic_groan2.ogg"
NTF_AmbienceStrings$(18) = "indoor_dist_generic_door_kick1.ogg"
NTF_AmbienceStrings$(19) = "indoor_dist_generic_explosion_bassy1.ogg"
NTF_AmbienceStrings$(20) = "indoor_dist_generic_explosion_bassy2.ogg"
NTF_AmbienceStrings$(21) = "indoor_dist_generic_gunfire_chaotic_ar1.ogg"
NTF_AmbienceStrings$(22) = "indoor_dist_generic_gunfire_chaotic_pistol2.ogg"
NTF_AmbienceStrings$(23) = "indoor_dist_generic_gunfire_sustained_ar1.ogg"
NTF_AmbienceStrings$(24) = "indoor_dist_generic_gunfire_sustained_lmg1.ogg"
NTF_AmbienceStrings$(25) = "indoor_dist_generic_gunfire_sustained_pistol2.ogg"
NTF_AmbienceStrings$(26) = "indoor_dist_generic_gunfire_sustained_shotgun1.ogg"
NTF_AmbienceStrings$(27) = "indoor_dist_generic_gunfire_sustained_smg2.ogg"
NTF_AmbienceStrings$(28) = "indoor_dist_generic_humanscream_long1.ogg"
NTF_AmbienceStrings$(29) = "indoor_dist_generic_humanscream_long2.ogg"
NTF_AmbienceStrings$(30) = "indoor_far_generic_explosion_small1.ogg"
NTF_AmbienceStrings$(31) = "indoor_far_generic_gunfire_chaotic_pistol1.ogg"
NTF_AmbienceStrings$(32) = "indoor_far_generic_gunfire_chaotic_smg1.ogg"
NTF_AmbienceStrings$(33) = "indoor_far_generic_gunfire_chaotic_smg2.ogg"
NTF_AmbienceStrings$(34) = "indoor_far_generic_gunfire_sustained_ar1.ogg"
NTF_AmbienceStrings$(35) = "indoor_far_generic_gunfire_sustained_ar2.ogg"
NTF_AmbienceStrings$(36) = "indoor_far_generic_gunfire_sustained_smg1.ogg"
NTF_AmbienceStrings$(37) = "indoor_far_generic_gunfire_sustained_smg2.ogg"
NTF_AmbienceStrings$(38) = "alley_lmg.ogg"
For i = 0 To 4
	NTF_AmbienceStrings$(39+i) = "int_amb"+(i+1)+".ogg"
Next
For i = 0 To 2
	NTF_AmbienceStrings$(44+i) = "scream"+(i+1)+".ogg"
Next
For i = 0 To 2
	NTF_AmbienceStrings$(47+i) = "indoor_camera_generic_underground_tremor"+(i+1)+".ogg"
Next
For i = 0 To 6
	NTF_AmbienceStrings$(50+i) = "indoor_dist_generic_metal_strike"+(i+1)+".ogg"
Next
For i = 0 To 3
	NTF_AmbienceStrings$(57+i) = "indoor_dist_generic_metal_squeak"+(i+1)+".ogg"
Next
For i = 0 To 3
	NTF_AmbienceStrings$(61+i) = "indoor_dist_generic_metal_strikeshort"+(i+1)+".ogg"
Next
For i = 0 To 2
	NTF_AmbienceStrings$(65+i) = "indoor_far_generic_gunfire_sustained_pistol"+(i+1)+".ogg"
Next
For i = 0 To 4
	NTF_AmbienceStrings$(68+i) = "indoor_far_generic_moan"+(i+1)+".ogg"
Next
For i = 0 To 4
	NTF_AmbienceStrings$(73+i) = "indoor_far_generic_snarl"+(i+1)+".ogg"
Next
For i = 0 To 3
	NTF_AmbienceStrings$(78+i) = "indoor_camera_generic_lights_flicker"+(i+1)+".ogg"
Next
For i = 0 To 2
	NTF_AmbienceStrings$(81+i) = "indoor_dist_generic_howl"+(i+1)+".ogg"
Next
For i = 0 To 2
	NTF_AmbienceStrings$(84+i) = "indoor_dist_generic_humanscream_short"+(i+1)+".ogg"
Next
For i = 0 To 3
	NTF_AmbienceStrings$(87+i) = "indoor_dist_generic_roar"+(i+1)+".ogg"
Next
For i = 0 To 4
	NTF_AmbienceStrings$(91+i) = "indoor_far_generic_explosion_med"+(i+1)+".ogg"
Next
For i = 0 To 2
	NTF_AmbienceStrings$(96+i) = "indoor_far_generic_gunfire_sustained_pistol"+(i+1)+".ogg"
Next
NTF_AmbienceStrings$(99) = "2scream.ogg"
NTF_AmbienceStrings$(100) = "2scream2.ogg"
For i = 0 To 2
	NTF_AmbienceStrings$(101+i) = "Boom"+(i+1)+".ogg"
Next
NTF_AmbienceStrings$(104) = "LowMoan.ogg"
NTF_AmbienceStrings$(105) = "Spooky.ogg"

DebugLog "--------------------------------------"
For i = 0 To 105
	DebugLog NTF_AmbienceStrings$(i)
Next
DebugLog "--------------------------------------"

Const NTF_RES_Max = 11

Dim NTF_RandomEventSound$(NTF_RES_Max)
NTF_RandomEventSound(0) = "7_classD_finished_off.ogg"
NTF_RandomEventSound(1) = "8_guard_is_compromised_by_loud_radio.ogg"
NTF_RandomEventSound(2) = "classD_pretends_tosurrender_but_doesnt.ogg"
NTF_RandomEventSound(3) = "grenadelauncher_panicked_discharge.ogg"
NTF_RandomEventSound(4) = "guard_squads_meet_each_other.ogg"
NTF_RandomEventSound(5) = "guards_accidental_friendly_fire_scientist.ogg"
NTF_RandomEventSound(6) = "guards_squad_attacked_bySCP_one_survivor.ogg"
NTF_RandomEventSound(7) = "guards_use_a_grenade.ogg"
NTF_RandomEventSound(8) = "mtf_breach_door.ogg"
NTF_RandomEventSound(9) = "mtf_finds_bodies.ogg"
NTF_RandomEventSound(10) = "mtf_prepares_to_apprehend_SCP.ogg"

DebugLog "--------------------------------------"
For i = 0 To NTF_RES_Max-1
	DebugLog NTF_RandomEventSound(i)
Next
DebugLog "--------------------------------------"

Dim NTF_IntroAmbienceStrings$(41)
For i = 0 To 6
	NTF_IntroAmbienceStrings$(i) = "outdoor_helo_generic_pass_dist_single"+(i+1)+".ogg"
Next
For i = 0 To 2
	NTF_IntroAmbienceStrings$(7+i) = "outdoor_helo_generic_pass_dist_squadron"+(i+1)+".ogg"
Next
For i = 0 To 4
	NTF_IntroAmbienceStrings$(10+i) = "outdoor_helo_generic_pass_far_double"+(i+1)+".ogg"
Next
For i = 0 To 8
	NTF_IntroAmbienceStrings$(15+i) = "outdoor_helo_generic_pass_far_single"+(i+1)+".ogg"
Next
For i = 0 To 4
	NTF_IntroAmbienceStrings$(24+i) = "outdoor_helo_generic_pass_xfar_double"+(i+1)+".ogg"
Next
For i = 0 To 6
	NTF_IntroAmbienceStrings$(29+i) = "outdoor_helo_generic_pass_xfar_single"+(i+1)+".ogg"
Next
For i = 0 To 4
	NTF_IntroAmbienceStrings$(36+i) = "outdoor_helo_generic_patrol_dist_long"+(i+3)+".ogg"
Next

DebugLog "--------------------------------------"
For i = 0 To 40
	DebugLog NTF_IntroAmbienceStrings$(i)
Next
DebugLog "--------------------------------------"

Global NTF_GasMaskBlood

Global NTF_UseLOD% = True
Global NTF_LODValue#
;Texture Details
;0 = Low
;1 = Medium
;2 = High
;3 = Very High
Global NTF_LODMode% = GetINIInt("NineTailedFoxMod\options.ini", "ingame", "texture details")
Select NTF_LODMode%
	Case 0
		NTF_LODValue# = 1.5
	Case 1
		NTF_LODValue# = 0.75
	Case 2
		NTF_LODValue# = 0.0
	Case 3
		NTF_LODValue# = -0.75
End Select
Global NTF_ZoneLoading% = GetINIInt("NineTailedFoxMod\options.ini", "ingame", "seperate zones")

Global SFXVolume# = GetINIFloat("NineTailedFoxMod\options.ini", "ingame", "sfx volume")
Global MenuTestSound% = 0
Global MenuTestSoundCHN = 0
Global CurrFrameLimit# = Min(FrameLimit%/200.0,2.0)
Global GunPitchShift% = GetINIInt("NineTailedFoxMod\options.ini", "ingame", "gun sfx pitch")
Global NTF_AntiAlias% = GetINIInt(OptionFile,"options","antialias")
Global NTF_LQModels% = GetINIInt("NineTailedFoxMod\options.ini", "ingame", "lq models")
Global NTF_ZoneChangeSFX

Global NTF_AchvMenuScroll# = 0.0
;Global NTF_LangMenuScroll# = 0.0

Global NTF_ChatSFX1 = 0, NTF_ChatSFX2 = 0, NTF_ChatCHN1 = 0, NTF_ChatCHN2 = 0

Global NTF_AchvIMG% = CreateImage(GraphicWidth,GraphicHeight)
;Global NTF_LangIMG% = CreateImage(GraphicWidth,GraphicHeight)
Const ClrR = 50, ClrG = 50, ClrB = 50

Global NTF_CurrZone% = 3

Global Contain173State% = 0
Global Contain173Timer# = 0.0
Global Contain173_SoundPlayed% = False

Global CanPlayerMove% = True

Const HIT_INTRO_HELI% = 6

Global Intro_SFX
Global Intro_SFX_Timer# = -10.0
Global Intro_CurrSound% = 0

Dim ClassDTextures(4)

Function UseChatSounds()
	
	If KeyHit(KEY_CHAT)
		If (Not ChatSFXOpened%)
			ChatSFXOpenedTimer# = 0.0
			ChatSFXOpened% = True
			FlushKeys()
		EndIf
	EndIf
	
	If NTF_RadioCHN <> 3 Then ChatSFXOpened% = False
	
	If ChatSFXOpened% = True
		If ChatSFXOpenedTimer# < 500.0
			ChatSFXOpenedColorFloat# = 255.0
			ChatSFXOpenedTimer# = ChatSFXOpenedTimer# + FPSfactor
		Else
			If ChatSFXOpenedColorFloat# > 3.0
				ChatSFXOpenedColorFloat# = ChatSFXOpenedColorFloat# - (2*FPSFactor)
			Else
				ChatSFXOpened% = False
			EndIf
		EndIf
		ChatSFXOpenedColor% = Int(ChatSFXOpenedColorFloat#)
		
		SetFont Font1%
		Color ChatSFXOpenedColor%,ChatSFXOpenedColor%,ChatSFXOpenedColor%
		Text 20,(GraphicHeight/2)-80,"1 Spotted"
		Text 20,(GraphicHeight/2)-60,"2 Stop right there"
		Text 20,(GraphicHeight/2)-40,"3 Searching"
		Text 20,(GraphicHeight/2)-20,"4 Target lost"
		Text 20,(GraphicHeight/2),"5 Tesla"
		Text 20,(GraphicHeight/2)+20,"6 SCP-173 containment box"
		Text 20,(GraphicHeight/2)+40,"7 SCP-173 containment chamber"
		Text 20,(GraphicHeight/2)+60,"8 SCP-173 inside containment"
		Text 20,(GraphicHeight/2)+80,"9 Target terminated"
		
		For np.NPCs = Each NPCs
			dist = EntityDistance(np\Collider,Collider)
			If dist < 10.0
				If np\NPCtype = NPCtype173
					If KeyHit(2)
						PlayChatSound("173spotted1")
						ChatSFXOpenedTimer# = 500.0
						If Contain173State% < 2
							Contain173State% = 1
						EndIf
					EndIf
					If KeyHit(7)
						If Contain173State% > 2
							PlayChatSound("173box",1,2)
							ChatSFXOpenedTimer# = 500.0
						EndIf
					EndIf
					If KeyHit(8)
						If Contain173State% = 3
							For r.Rooms = Each Rooms
								If r\RoomTemplate\Name$ = "start"
									If PlayerRoom = r
										DebugLog Distance(EntityX(Curr173\Collider),EntityZ(Curr173\Collider),EntityX(r\obj,True)+1024*RoomScale,EntityZ(r\obj,True)+384*RoomScale)
										If Distance(EntityX(Curr173\Collider),EntityZ(Curr173\Collider),EntityX(r\obj,True)+1024*RoomScale,EntityZ(r\obj,True)+384*RoomScale)>13.0 Then
											PlayChatSound("173cont1")
											ChatSFXOpenedTimer# = 500.0
											Curr173\Idle = 3
											Curr173\TargetEnt% = 0
											Contain173State% = 4
										EndIf
									EndIf
									Exit
								EndIf
							Next
						EndIf
					EndIf
					If KeyHit(9)
						If Contain173State% = 4
							PlayChatSound("173cont",2,3)
							ChatSFXOpenedTimer# = 500.0
						EndIf
					EndIf
				ElseIf np\NPCtype = NPCtype106
					If KeyHit(2)
						PlayChatSound("106spotted",1,3)
						ChatSFXOpenedTimer# = 500.0
					EndIf
				ElseIf np\NPCtype = NPCtype096
					If KeyHit(2)
						PlayChatSound("096spotted")
						ChatSFXOpenedTimer# = 500.0
					EndIf
				ElseIf np\NPCtype = NPCtypeZombie
					If KeyHit(2)
						PlayChatSound("0491")
						ChatSFXOpenedTimer# = 500.0
					EndIf
					If KeyHit(10)
						PlayChatSOund("0492")
						ChatSFXOpenedTimer# = 500.0
					EndIf
				ElseIf np\NPCtype = NPCtypeD
					If KeyHit(2)
						PlayChatSound("classd",0,1)
						ChatSFXOpenedTimer# = 500.0
					EndIf
					If KeyHit(3)
						PlayChatSound("stop",0,2)
						ChatSFXOpenedTimer# = 500.0
					EndIf
					If KeyHit(10)
						PlayChatSound("targetterminated",1,3)
						ChatSFXOpenedTimer# = 500.0
					EndIf
				EndIf
			EndIf
		Next
		
		If KeyHit(4)
			PlayChatSound("searching",1,3)
			ChatSFXOpenedTimer# = 500.0
		EndIf
		If KeyHit(5)
			PlayChatSound("targetlost",1,2)
			ChatSFXOpenedTimer# = 500.0
		EndIf
		
		For e.Events = Each Events
			If e\EventName = "room2tesla"
				If PlayerRoom = e\room
					If KeyHit(6)
						;If e\EventState2 = 0 Then
						;	If e\EventState3 <=0 Then 
								;temp = False
								;For n.NPCs = Each NPCs
								;	If n\NPCtype = NPCtypeMTF Then
								;		If Abs(EntityX(n\Collider)-EntityX(e\room\obj,True))<4.0 Then
								;			If Abs(EntityZ(n\Collider)-EntityZ(e\room\obj,True))<4.0 Then
								;				temp = True
						If e\EventState = 0 Then
							PlayChatSound("tesla0")
							LoadEventSound(e,"NineTailedFoxMod\SFX\Tesla1.ogg")
							e\SoundCHN = PlaySound(e\Sound)
									;n\Idle = 70*10
							e\EventState2 = 70*100
							
							ChatSFXOpenedTimer# = 500.0
						EndIf
								;			EndIf
								;		EndIf
								;	EndIf
								;Next
								;If temp = False Then e\EventState2=70*3.5
						e\EventState3=e\EventState3+140
							;Else
							;	e\EventState3=e\EventState3-FPSfactor
							;EndIf
						;Else
						;	e\EventState2 = Max(e\EventState2-FPSfactor,0)
						;EndIf
					EndIf
					If e\EventState2 <= 0
						If e\EventState3 <=0 Then
							e\EventState2 = 0
						Else
							e\EventState3=e\EventState3-FPSfactor
						EndIf
					Else
						e\EventState2 = Max(e\EventState2-FPSfactor,0)
					EndIf				
				EndIf
			EndIf
		Next		
		
	EndIf
	
End Function

Function PlayChatSound(sound$,min%=0,max%=0)
	Local random% = Rand(Min%,Max%)
	
	If ChannelPlaying(ChatSFXCHN) Then StopChannel(ChatSFXCHN)
	
	ChatSFXCHN = PlaySound(ChatSFX_On)
	ChatSFX_CurrSound = 1
	If ChannelPlaying(NTF_ChatCHN1) Then StopChannel(NTF_ChatCHN1)
	If ChannelPlaying(NTF_ChatCHN2) Then StopChannel(NTF_ChatCHN2)
	If NTF_ChatSFX1 <> 0 Then FreeSound NTF_ChatSFX1 : NTF_ChatSFX1 = 0
	If NTF_ChatSFX2 <> 0 Then FreeSound NTF_ChatSFX2 : NTF_ChatSFX2 = 0
	If Min%=0 And Max%=0
		NTF_ChatSFX1 = LoadSound_Strict("NineTailedFoxMod\SFX\MTF\Player_Normal\"+sound$+".ogg")
		NTF_ChatSFX2 = LoadSound_Strict("NineTailedFoxMod\SFX\MTF\Player_GasMask\"+sound$+".ogg")
	Else
		NTF_ChatSFX1 = LoadSound_Strict("NineTailedFoxMod\SFX\MTF\Player_Normal\"+(sound$+random%)+".ogg")
		NTF_ChatSFX2 = LoadSound_Strict("NineTailedFoxMod\SFX\MTF\Player_GasMask\"+(sound$+random%)+".ogg")
	EndIf
	NTF_ChatCHN1 = 0
	NTF_ChatCHN2 = 0
	
End Function

Function UpdateChatSound()
	
	If ChatSFX_CurrSound = 1
		If (Not ChannelPlaying(ChatSFXCHN))
			NTF_ChatCHN1 = PlaySound(NTF_ChatSFX1)
			NTF_ChatCHN2 = PlaySound(NTF_ChatSFX2)
			ChatSFX_CurrSound = 2
		EndIf
	ElseIf ChatSFX_CurrSound = 2
		If (Not ChannelPlaying(NTF_ChatCHN1)) And (Not ChannelPlaying(NTF_ChatCHN2))
			ChatSFXCHN = PlaySound(ChatSFX_Off)
			ChatSFX_CurrSound = 0
		EndIf
	EndIf
	
	If WearingGasMask
		ChannelVolume NTF_ChatCHN1,0.0
		ChannelVolume NTF_ChatCHN2,1.0*SFXVolume#
	Else
		ChannelVolume NTF_ChatCHN1,1.0*SFXVolume#
		ChannelVolume NTF_ChatCHN2,0.0
	EndIf
	
	ChannelVolume ChatSFXCHN,1.0*SFXVolume#
	
End Function

Function LoadModStuff()
	
	NTF_CurrZone% = 3
	
	CanPlayerMove% = True
	
	MTF_PlayerViewModelPVT = CreatePivot()
	
	MTF_PlayerViewModel = LoadAnimMesh("NineTailedFoxMod\GFX\npcs\MTF_PlayerBody.b3d",MTF_PlayerViewModelPVT)
	temp# = (GetINIFloat("DATA\NPCs.ini", "MTF", "scale") / 2.5)
	ScaleEntity MTF_PlayerViewModel, temp, temp, temp
	PositionEntity MTF_PlayerViewModel,0,0,-0.2
	HideEntity MTF_PlayerViewModel
	
	BloodSpitSprite1 = LoadSprite("GFX\blooddrop1.png",1+2)
	;ScaleSprite BloodSpitSprite1,0.25,0.25
	SpriteViewMode BloodSpitSprite1,1
	BloodSpitSprite2 = LoadSprite("GFX\blooddrop2.png",1+2)
	;ScaleSprite BloodSpitSprite2,0.25,0.25
	SpriteViewMode BloodSpitSprite2,1
	
	MTFObj2 = LoadAnimMesh_Strict("NineTailedFoxMod\GFX\npcs\MTF3.b3d")
	HideEntity MTFObj2
	D035Obj = LoadAnimMesh_Strict("GFX\npcs\035.b3d")
	HideEntity D035Obj
	NaziObj = LoadAnimMesh_Strict("GFX\npcs\naziofficer.b3d")
	HideEntity NaziObj
	ZombieObj = LoadAnimMesh_Strict("GFX\npcs\zombie1.b3d")
	HideEntity ZombieObj
	ClassDObj2 = LoadAnimMesh_Strict("NineTailedFoxMod\GFX\npcs\classd2.b3d")
	HideEntity ClassDObj2
	B457Obj = LoadAnimMesh_Strict("NineTailedFoxMod\GFX\npcs\457test.b3d")
	HideEntity B457Obj
	N966Obj = LoadAnimMesh_Strict("GFX\npcs\scp-966.b3d")
	HideEntity N966Obj
	
	NTF_BodyTextures(0) = LoadTexture_Strict("NineTailedFoxMod\GFX\npcs\body1.jpg")
	NTF_BodyTextures(1) = LoadTexture_Strict("NineTailedFoxMod\GFX\npcs\body2.jpg")
	
	;0: Spotted (SCPs,Class-Ds)
	;1: Stop (Class-D in sight)
	;2: Searching (Class-D escaped)
	;3: Target Lost (Class-D escaped too long)
	;4: Tesla (to deactivate Tesla gate)
	;5: 173box (173 has been put in his containment box)
	;6: 173cont (173 is inside containment chamber, Part1)
	;7: 173cont (173 is inside containment chamber, Part2)
	;8: Target terminated (Class-Ds,049-2)
	;ChatSFX(0,1) = LoadSound_Strict("NineTailedFoxMod\SFX\player\096spotted.ogg")
	;ChatSFX(0,2) = LoadSound_Strict("NineTailedFoxMod\SFX\player\106spotted1.ogg")
	;ChatSFX(0,3) = LoadSound_Strict("NineTailedFoxMod\SFX\player\106spotted2.ogg")
	;ChatSFX(0,4) = LoadSound_Strict("NineTailedFoxMod\SFX\player\106spotted3.ogg")
	;ChatSFX(0,5) = LoadSound_Strict("NineTailedFoxMod\SFX\player\173spotted1.ogg")
	;ChatSFX(0,6) = LoadSound_Strict("NineTailedFoxMod\SFX\player\173spotted2.ogg")
	;ChatSFX(0,7) = LoadSound_Strict("NineTailedFoxMod\SFX\player\0491.ogg")
	;ChatSFX(0,8) = LoadSound_Strict("NineTailedFoxMod\SFX\player\ClassD0.ogg")
	;ChatSFX(0,9) = LoadSound_Strict("NineTailedFoxMod\SFX\player\ClassD1.ogg")
	;ChatSFX(1,0) = LoadSound_Strict("NineTailedFoxMod\SFX\player\Stop0.ogg")
	;ChatSFX(1,1) = LoadSound_Strict("NineTailedFoxMod\SFX\player\Stop1.ogg")
	;ChatSFX(1,2) = LoadSound_Strict("NineTailedFoxMod\SFX\player\Stop2.ogg")
	;ChatSFX(2,0) = LoadSound_Strict("NineTailedFoxMod\SFX\player\Searching1.ogg")
	;ChatSFX(2,1) = LoadSound_Strict("NineTailedFoxMod\SFX\player\Searching2.ogg")
	;ChatSFX(2,2) = LoadSound_Strict("NineTailedFoxMod\SFX\player\Searching3.ogg")
	;ChatSFX(3,0) = LoadSound_Strict("NineTailedFoxMod\SFX\player\TargetLost1.ogg")
	;ChatSFX(3,1) = LoadSound_Strict("NineTailedFoxMod\SFX\player\TargetLost2.ogg")
	;ChatSFX(4,0) = LoadSound_Strict("NineTailedFoxMod\SFX\player\tesla0.ogg")
	;ChatSFX(5,0) = LoadSound_Strict("NineTailedFoxMod\SFX\player\173box1.ogg")
	;ChatSFX(5,1) = LoadSound_Strict("NineTailedFoxMod\SFX\player\173box2.ogg")
	;ChatSFX(6,0) = LoadSound_Strict("NineTailedFoxMod\SFX\player\173cont1.ogg")
	;ChatSFX(6,1) = LoadSound_Strict("NineTailedFoxMod\SFX\player\173cont2.ogg")
	;ChatSFX(7,0) = LoadSound_Strict("NineTailedFoxMod\SFX\player\173cont3.ogg")
	;ChatSFX(8,0) = LoadSound_Strict("NineTailedFoxMod\SFX\player\Targetterminated1.ogg")
	;ChatSFX(8,1) = LoadSound_Strict("NineTailedFoxMod\SFX\player\TargetTerminated2.ogg")
	;ChatSFX(8,2) = LoadSound_Strict("NineTailedFoxMod\SFX\player\TargetTerminated3.ogg")
	;ChatSFX(8,3) = LoadSound_Strict("NineTailedFoxMod\SFX\player\0492.ogg")
	
	ChatSFX_On = LoadSound_Strict("NineTailedFoxMod\SFX\player\MTF_Radio_On.ogg")
	ChatSFX_Off = LoadSound_Strict("NineTailedFoxMod\SFX\player\MTF_Radio_Off.ogg")
	
	ChatSFX_CurrSound = 0
	
	For i = 0 To 7
		NTF_PainSFX(i)=LoadSound_Strict("NineTailedFoxMod\SFX\player\pain"+(i+1)+".ogg")
	Next
	For i = 0 To 1
		NTF_PainWeakSFX(i)=LoadSound_Strict("NineTailedFoxMod\SFX\player\painweak"+(i+1)+".ogg")
	Next
	
	;NTF_AmbientSFX(0,0) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\brief_encounter.ogg")
	;NTF_AmbientSFX(0,1) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\friendly_fire.ogg")
	;NTF_AmbientSFX(0,2) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\int_bursts.ogg")
	;NTF_AmbientSFX(0,3) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\panic.ogg")
	;NTF_AmbientSFX(0,4) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_camera_generic_underground_jolt1.ogg")
	;NTF_AmbientSFX(0,5) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_camera_generic_underground_tremor_high1.ogg")
	;NTF_AmbientSFX(0,6) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_door_kick1.ogg")
	;NTF_AmbientSFX(0,7) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_chaotic_pistol1.ogg")
	;NTF_AmbientSFX(0,8) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_sustained_pistol1.ogg")
	;NTF_AmbientSFX(0,9) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_sustained_smg1.ogg")
	;NTF_AmbientSFX(0,10) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_metal_break1.ogg")
	;NTF_AmbientSFX(0,11) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_metal_scrape1.ogg")
	;NTF_AmbientSFX(0,12) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_metal_scrape2.ogg")
	;NTF_AmbientSFX(0,13) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_metal_stress1.ogg")
	;NTF_AmbientSFX(0,14) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_metal_stress2.ogg")
	;NTF_AmbientSFX(0,15) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_metaldoor_kick1.ogg")
	;NTF_AmbientSFX(0,16) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_groan1.ogg")
	;NTF_AmbientSFX(0,17) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_groan2.ogg")
	;NTF_AmbientSFX(0,18) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_door_kick1.ogg")
	;NTF_AmbientSFX(0,19) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_explosion_bassy1.ogg")
	;NTF_AmbientSFX(0,20) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_explosion_bassy2.ogg")
	;NTF_AmbientSFX(0,21) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_chaotic_ar1.ogg")
	;NTF_AmbientSFX(0,22) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_chaotic_pistol2.ogg")
	;NTF_AmbientSFX(0,23) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_sustained_ar1.ogg")
	;NTF_AmbientSFX(0,24) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_sustained_lmg1.ogg")
	;NTF_AmbientSFX(0,25) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_sustained_pistol2.ogg")
	;NTF_AmbientSFX(0,26) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_sustained_shotgun1.ogg")
	;NTF_AmbientSFX(0,27) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_gunfire_sustained_smg2.ogg")
	;NTF_AmbientSFX(0,28) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_humanscream_long1.ogg")
	;NTF_AmbientSFX(0,29) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_humanscream_long2.ogg")
	;NTF_AmbientSFX(0,30) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_explosion_small1.ogg")
	;NTF_AmbientSFX(0,31) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_gunfire_chaotic_pistol1.ogg")
	;NTF_AmbientSFX(0,32) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_gunfire_chaotic_smg1.ogg")
	;NTF_AmbientSFX(0,33) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_gunfire_chaotic_smg2.ogg")
	;NTF_AmbientSFX(0,34) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_gunfire_sustained_ar1.ogg")
	;NTF_AmbientSFX(0,35) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_gunfire_sustained_ar2.ogg")
	;NTF_AmbientSFX(0,36) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_gunfire_sustained_smg1.ogg")
	;NTF_AmbientSFX(0,37) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_gunfire_sustained_smg2.ogg")
	;NTF_AmbientSFX(0,38) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\alley_lmg.ogg")
	;For i = 0 To (NTF_1MaxAmbient%-1)
	;	NTF_AmbientSFX(1,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\int_amb"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_2MaxAmbient%-1)
	;	NTF_AmbientSFX(2,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\scream"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_3MaxAmbient%-1)
	;	NTF_AmbientSFX(3,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_camera_generic_underground_tremor"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_4MaxAmbient%-1)
	;	NTF_AmbientSFX(4,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_metal_strike"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_5MaxAmbient%-1)
	;	NTF_AmbientSFX(5,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_metal_squeak"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_6MaxAmbient%-1)
	;	NTF_AmbientSFX(6,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_metal_strikeshort"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_7MaxAmbient%-1)
	;	NTF_AmbientSFX(7,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_gunfire_sustained_pistol"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_8MaxAmbient%-1)
	;	NTF_AmbientSFX(8,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_moan"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_9MaxAmbient%-1)
	;	NTF_AmbientSFX(9,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_snarl"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_10MaxAmbient%-1)
	;	NTF_AmbientSFX(10,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_camera_generic_lights_flicker"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_11MaxAmbient%-1)
	;	NTF_AmbientSFX(11,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_howl"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_12MaxAmbient%-1)
	;	NTF_AmbientSFX(12,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_humanscream_short"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_13MaxAmbient%-1)
	;	NTF_AmbientSFX(13,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_dist_generic_roar"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_14MaxAmbient%-1)
	;	NTF_AmbientSFX(14,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_explosion_med"+(i+1)+".ogg")
	;Next
	;For i = 0 To (NTF_15MaxAmbient%-1)
	;	NTF_AmbientSFX(15,i) = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\indoor_far_generic_gunfire_sustained_pistol"+(i+1)+".ogg")
	;Next
	
	NTF_457Death = LoadSound_Strict("SFX\294\burn.ogg")
	NTF_457Flame = LoadSound_Strict("NineTailedFoxMod\SFX\457\Fire2.ogg")
	
	Ash=LoadSprite("NineTailedFoxMod\GFX\fire_particle.bmp"):HideEntity Ash
	flame01=LoadSprite("NineTailedFoxMod\GFX\smk01.bmp"):HideEntity flame01
	
	NTF_RadioCHN = 3
	
	NTF_BrokenDoorSFX = LoadSound_Strict("NineTailedFoxMod\SFX\ambience\rooms\brokendoor.ogg")
	
	NTF_1499Sky = sky_CreateSky("NineTailedFoxMod\GFX\map\sky\1499sky")
	HideEntity NTF_1499Sky
	
	NTF_Wearing1499% = False
	NTF_1499PrevX# = 0.0
	NTF_1499PrevY# = 0.0
	NTF_1499PrevZ# = 0.0
	NTF_1499PrevRoom$ = ""
	NTF_1499X# = 0.0
	NTF_1499Y# = 0.0
	NTF_1499Z# = 0.0
	
	NTF_1499EnterSFX% = LoadSound_Strict("NineTailedFoxMod\SFX\1499\1499_mfe_vhd_00.ogg")
	NTF_1499LeaveSFX% = LoadSound_Strict("NineTailedFoxMod\SFX\1499\1499_mfe_lve_10.ogg")
	
	NTF_BloodOverlay(0,0) = LoadSprite("NineTailedFoxMod\GFX\BloodOverlay1.jpg",1+2)
	SpriteViewMode NTF_BloodOverlay(0,0),1
	ScaleSprite NTF_BloodOverlay(0,0),3,2
	EntityParent NTF_BloodOverlay(0,0),ark_blur_cam
	MoveEntity NTF_BloodOverlay(0,0),0,0,1
	EntityFX NTF_BloodOverlay(0,0),1
	EntityOrder NTF_BloodOverlay(0,0),-2
	HideEntity NTF_BloodOverlay(0,0)
	
	NTF_BloodOverlay(0,1) = CreateSprite()
	SpriteViewMode NTF_BloodOverlay(0,1),1
	ScaleSprite NTF_BloodOverlay(0,1),3,2
	EntityParent NTF_BloodOverlay(0,1),ark_blur_cam
	MoveEntity NTF_BloodOverlay(0,1),0,0,1
	EntityFX NTF_BloodOverlay(0,1),1
	EntityOrder NTF_BloodOverlay(0,1),-1
	EntityColor NTF_BloodOverlay(0,1),50,0,0
	HideEntity NTF_BloodOverlay(0,1)
	
	;NTF_RadioSFX1(0) = LoadSound_Strict("NineTailedFoxMod\SFX\voice\096chatter.ogg")
	;For i = 1 To 4
	;	NTF_RadioSFX1(i) = LoadSound_Strict("SFX\MTF\Random"+i+".ogg")
	;Next
	;NTF_RadioSFX2(0) = LoadSound_Strict("SFX\radio\Chatter3.ogg")
	;NTF_RadioSFX2(1) = LoadSound_Strict("SFX\radio\OhGod.ogg")
	;NTF_RadioSFX2(2) = LoadSound_Strict("SFX\radio\Chatter2.ogg")
	;NTF_RadioSFX2(3) = LoadSound_Strict("SFX\radio\franklin1.ogg")
	;NTF_RadioSFX2(4) = LoadSound_Strict("SFX\radio\Chatter4.ogg")
	;NTF_RadioSFX2(5) = LoadSound_Strict("SFX\035\radio1.ogg")
	;NTF_RadioSFX2(6) = LoadSound_Strict("SFX\radio\Chatter1.ogg")
	;NTF_RadioSFX2(7) = LoadSound_Strict("SFX\radio\franklin2.ogg")
	;NTF_RadioSFX2(8) = LoadSound_Strict("SFX\035\radio2.ogg")
	;NTF_RadioSFX2(9) = LoadSound_Strict("SFX\radio\franklin3.ogg")
	;NTF_RadioSFX2(10) = LoadSound_Strict("SFX\radio\franklin4.ogg")
	
	NTF_GasMaskBlood = LoadSprite("NineTailedFoxMod\GFX\BloodOverlay.jpg",1+2,ark_blur_cam)
	ScaleSprite(NTF_GasMaskBlood, Max(GraphicWidth / 1024.0, 1.0), Max(GraphicHeight / 1024.0 * 0.8, 0.8))
	EntityBlend (NTF_GasMaskBlood, 2)
	EntityFX(NTF_GasMaskBlood, 1)
	EntityOrder GasMaskOverlay, -1000
	MoveEntity(NTF_GasMaskBlood, 0, 0, 1.0)
	HideEntity(NTF_GasMaskBlood)
	
	TextureLodBias
	
	NTF_ZoneChangeSFX = LoadSound_Strict("SFX\Doors\DoorCheckpoint.ogg")
	
	Contain173State% = 0
	Contain173Timer# = 0.0
	
	SplashText_Timer# = 0.0
	SplashText_Timer2# = 0.0
	SplashText_Timer3# = 255.0
	SplashText_CurrentLength% = 0
	SplashText_X# = 0.0
	SplashText_Y# = 0.0
	SplashText_Text$ = ""
	SplashText_ShowTime# = 0.0
	SplashText_Length% = 0
	
	For i = 0 To 2
		ClassDTextures(i) = LoadTexture_Strict("NineTailedFoxMod\GFX\npcs\classd"+(i+1)+".jpg")
	Next
	ClassDTextures(3) = LoadTexture_Strict("NineTailedFoxMod\GFX\npcs\classd5.jpg")
	
End Function

Function DeleteModStuff()
	
	;FreeSound ChatSFX(0,1) : ChatSFX(0,1) = 0
	;FreeSound ChatSFX(0,2) : ChatSFX(0,2) = 0
	;FreeSound ChatSFX(0,3) : ChatSFX(0,3) = 0
	;FreeSound ChatSFX(0,4) : ChatSFX(0,4) = 0
	;FreeSound ChatSFX(0,5) : ChatSFX(0,5) = 0
	;FreeSound ChatSFX(0,6) : ChatSFX(0,6) = 0
	;FreeSound ChatSFX(0,7) : ChatSFX(0,7) = 0
	;FreeSound ChatSFX(0,8) : ChatSFX(0,8) = 0
	;FreeSound ChatSFX(0,9) : ChatSFX(0,9) = 0
	;FreeSound ChatSFX(1,0) : ChatSFX(1,0) = 0
	;FreeSound ChatSFX(1,1) : ChatSFX(1,1) = 0
	;FreeSound ChatSFX(1,2) : ChatSFX(1,2) = 0
	;FreeSound ChatSFX(2,0) : ChatSFX(2,0) = 0
	;FreeSound ChatSFX(2,1) : ChatSFX(2,1) = 0
	;FreeSound ChatSFX(2,2) : ChatSFX(2,2) = 0
	;FreeSound ChatSFX(3,0) : ChatSFX(3,0) = 0
	;FreeSound ChatSFX(3,1) : ChatSFX(3,1) = 0
	;FreeSound ChatSFX(4,0) : ChatSFX(4,0) = 0
	;FreeSound ChatSFX(5,0) : ChatSFX(5,0) = 0
	;FreeSound ChatSFX(5,1) : ChatSFX(5,1) = 0
	;FreeSound ChatSFX(6,0) : ChatSFX(6,0) = 0
	;FreeSound ChatSFX(6,1) : ChatSFX(6,1) = 0
	;FreeSound ChatSFX(7,0) : ChatSFX(7,0) = 0
	;FreeSound ChatSFX(8,0) : ChatSFX(8,0) = 0
	;FreeSound ChatSFX(8,1) : ChatSFX(8,1) = 0
	;FreeSound ChatSFX(8,2) : ChatSFX(8,2) = 0
	;FreeSound ChatSFX(8,3) : ChatSFX(8,3) = 0
	
	For i = 0 To 7
		FreeSound NTF_PainSFX(i) : NTF_PainSFX(i) = 0
	Next
	For i = 0 To 1
		FreeSound NTF_PainWeakSFX(i) : NTF_PainWeakSFX(i) = 0
	Next
	;For i = 0 To 38
	;	FreeSound NTF_AmbientSFX(0,i) : NTF_AmbientSFX(0,i)=0
	;Next
	;For i = 0 To (NTF_1MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(1,i) : NTF_AmbientSFX(1,i)=0
	;Next
	;For i = 0 To (NTF_2MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(2,i) : NTF_AmbientSFX(2,i)=0
	;Next
	;For i = 0 To (NTF_3MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(3,i) : NTF_AmbientSFX(3,i)=0
	;Next
	;For i = 0 To (NTF_4MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(4,i) : NTF_AmbientSFX(4,i)=0
	;Next
	;For i = 0 To (NTF_5MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(5,i) : NTF_AmbientSFX(5,i)=0
	;Next
	;For i = 0 To (NTF_6MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(6,i) : NTF_AmbientSFX(6,i)=0
	;Next
	;For i = 0 To (NTF_7MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(7,i) : NTF_AmbientSFX(7,i)=0
	;Next
	;For i = 0 To (NTF_8MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(8,i) : NTF_AmbientSFX(8,i)=0
	;Next
	;For i = 0 To (NTF_9MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(9,i) : NTF_AmbientSFX(9,i)=0
	;Next
	;For i = 0 To (NTF_10MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(10,i) : NTF_AmbientSFX(10,i)=0
	;Next
	;For i = 0 To (NTF_11MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(11,i) : NTF_AmbientSFX(11,i)=0
	;Next
	;For i = 0 To (NTF_12MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(12,i) : NTF_AmbientSFX(12,i)=0
	;Next
	;For i = 0 To (NTF_13MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(13,i) : NTF_AmbientSFX(13,i)=0
	;Next
	;For i = 0 To (NTF_14MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(14,i) : NTF_AmbientSFX(14,i)=0
	;Next
	;For i = 0 To (NTF_15MaxAmbient%-1)
	;	FreeSound NTF_AmbientSFX(15,i) : NTF_AmbientSFX(15,i)=0
	;Next
	FreeSound NTF_457Death : NTF_457Death = 0
	FreeSound NTF_457Flame : NTF_547Flame = 0
	
	If ChannelPlaying(ChatSFXCHN) Then StopChannel(ChatSFXCHN)
	
	FreeSound NTF_BrokenDoorSFX : NTF_BrokenDoorSFX = 0
	
	FreeSound NTF_1499EnterSFX%
	FreeSound NTF_1499LeaveSFX%
	
	If ChannelPlaying(NTF_ChatCHN1) Then StopChannel(NTF_ChatCHN1)
	If ChannelPlaying(NTF_ChatCHN2) Then StopChannel(NTF_ChatCHN2)
	
	If NTF_ChatSFX1 <> 0 Then FreeSound NTF_ChatSFX1 : NTF_ChatSFX1 = 0
	If NTF_ChatSFX2 <> 0 Then FreeSound NTF_ChatSFX2 : NTF_ChatSFX2 = 0
	
	If NTF_ZoneChangeSFX <> 0 Then FreeSound NTF_ZoneChangeSFX : NTF_ZoneChangeSFX = 0
	
	Contain173State% = 0
	Contain173Timer# = 0.0
	
	If Intro_SFX <> 0 Then FreeSound Intro_SFX : Intro_SFX = 0
	Intro_SFX_Timer# = -10.0
	Intro_CurrSound% = 0
	
End Function

Function UpdatePlayerModel()
	
	PositionEntity MTF_PlayerViewModelPVT,EntityX(Collider),EntityY(Collider),EntityZ(Collider)
	RotateEntity MTF_PlayerViewModelPVT,0,EntityYaw(Collider),0
	
	If CurrSpeed > 0.03
		Animate2(MTF_PlayerViewModel,AnimTime(MTF_PlayerViewModel),209,237,0.5,True)
	ElseIf CurrSpeed < 0.03 And CurrSpeed > 0.01
		Animate2(MTF_PlayerViewModel,AnimTime(MTF_PlayerViewModel),149,208,0.5,True)
	Else
		Animate2(MTF_PlayerViewModel,AnimTime(MTF_PlayerViewModel),1,148,0.5,True)
	EndIf
	
End Function

Type BloodSpit
	Field obj%
	Field x#,y#,z#
	Field KillTimer#
	Field DirectionRAND
End Type

Function CreateBloodSpit.BloodSpit(x#,y#,z#)
	BS.BloodSpit = New BloodSpit
	
	;BS\obj = CopyEntity(BloodSpitSprite(Rand(0,1)))
	random% = Rand(0,1)
	;If (Not n\NPCType = NPCType173) Then
		If random%=0
			BS\obj = CopyEntity(BloodSpitSprite1)
		Else
			BS\obj = CopyEntity(BloodSpitSprite2)
		EndIf
	;EndIf
	ScaleSprite BS\obj,Rand(0.1,0.25),Rand(0.1,0.25)
	BS\x# = x#
	BS\y# = y#
	BS\z# = z#
	PositionEntity BS\obj,x#,y#,z#
	BS\DirectionRAND = Rand(0,3)
	
	Return BS
End Function

Function UpdateBloodSpit()
	
	For BS.BloodSpit = Each BloodSpit
		If BS\KillTimer# < 2000.0
			BS\KillTimer# = BS\KillTimer# + FPSFactor#
			Select BS\DirectionRAND
				Case 0
					MoveEntity BS\obj,0,0,0.1
				Case 1
					MoveEntity BS\obj,0.1,0,0
				Case 2
					MoveEntity BS\obj,0,0,-0.1
				Case 3
					MoveEntity BS\obj,-0.1,0,0
			End Select
			TranslateEntity BS\obj,0,-0.1*FPSFactor,0
		Else
			FreeEntity BS\obj:BS\obj=0
			Delete BS
		EndIf
	Next
	
End Function

Function DamageKevlar(Damage%)
	
	If Kevlar_ExtraHealth%=0
		Kevlar_Health% = Kevlar_Health% - Int(Damage%)
		If Kevlar_Health% < 0 Then Kevlar_Health% = 0
	Else
		Kevlar_ExtraHealth% = Kevlar_ExtraHealth% - Int(Damage%)
		If Kevlar_ExtraHealth% < 0
			Kevlar_Health% = Kevlar_Health% + Kevlar_ExtraHealth%
			Kevlar_ExtraHealth% = 0
		EndIf
	EndIf
	
End Function

Function FindError()
	
	If (Not NTF_DisableConsoleOpening%) Then Return
	
	If NTF_ErrorAmount%>0
		SetFont Font1%
		Color 255,0,0
		Text 0,0,NTF_ErrorAmount+" new Errors found: See Console for details"
	EndIf
	
	If ConsoleOpen Then NTF_ErrorAmount% = 0
	
End Function

;Each Flame of the fire
Type flame
	Field ent
	Field ang#
	Field size#
	Field alph#
	Field dis#
	Field dx#, dy#, dz#
End Type

;The fire itself
Type fire
	Field piv
	; Direction
	Field dx#, dy#, dz#
	Field flag$
End Type

;Hot ashes
Type ash_particle
	Field ent
	Field alpha#
	Field dx#,dy#,dz#
	Field pop
End Type

;Add a flame to the fire
Function Add_flame(x#,y#,z#,size#=1,dis#=.016,dx#=0,dy#=0.3,dz#=0)
	a.flame=New flame
	a\ent=CopyEntity(flame01)
	PositionEntity a\ent,x,y,z
	a\alph=1
	a\size=size
	a\dis=dis
	a\ang=Rnd(360)
	ScaleSprite a\ent,a\size,a\size
	EntityColor a\ent,Rnd(150,255),Rnd(0,100),0
	a\dx=dx
	a\dy=dy
	a\dz=dz
End Function

;Update flames
Function Update_flames()
	For a.flame=Each flame
		If a\alph>0.01 Then
			a\alph=a\alph-a\dis
			EntityAlpha a\ent,a\alph
			RotateSprite a\ent,a\ang
			a\ang=a\ang+.2
			MoveEntity a\ent,a\dx,a\dy,a\dz
		Else
			FreeEntity a\ent
			Delete a
		End If
	Next
End Function

;Erase all flames
Function Erase_flames()
	For a.flame=Each flame
		If a\ent<>0 Then FreeEntity a\ent
	Next
	Delete Each flame
End Function

;Update all fires
Function Update_Fires()
	For a.fire=Each fire
		Add_flame(EntityX(a\piv)+Rnd(-0.1,0.1),EntityY(a\piv),EntityZ(a\piv)+Rnd(-0.1,0.1),Rnd(0.2,0.6),.04,a\dx,a\dy,a\dz)
		Add_flame(EntityX(a\piv)+Rnd(-0.1,0.1),EntityY(a\piv),EntityZ(a\piv)+Rnd(-0.1,0.1),Rnd(0.2,0.6),.04,a\dx,a\dy,a\dz)
		Add_flame(EntityX(a\piv)+Rnd(-0.1,0.1),EntityY(a\piv),EntityZ(a\piv)+Rnd(-0.1,0.1),Rnd(0.2,0.6),.04,a\dx,a\dy,a\dz)
		Add_flame(EntityX(a\piv)+Rnd(-0.1,0.1),EntityY(a\piv),EntityZ(a\piv)+Rnd(-0.1,0.1),Rnd(0.2,0.6),.04,a\dx,a\dy,a\dz)
		Add_flame(EntityX(a\piv)+Rnd(-0.1,0.1),EntityY(a\piv),EntityZ(a\piv)+Rnd(-0.1,0.1),Rnd(0.2,0.6),.04,a\dx,a\dy,a\dz)
		Add_flame(EntityX(a\piv)+Rnd(-0.1,0.1),EntityY(a\piv),EntityZ(a\piv)+Rnd(-0.1,0.1),Rnd(0.2,0.6),.04,a\dx,a\dy,a\dz)
	Next
	Update_flames()
End Function

;Erase all fires
Function Erase_Fires()
	For a.fire=Each fire
		If a\piv<>0 Then FreeEntity a\piv
	Next
	Delete Each fire
End Function

;Add a fire to the scene
Function Add_Fire.fire(x#,y#,z#,dx#=0,dy#=.05,dz#=0,flag$="")
	a.fire=New fire
	a\piv=CreatePivot()
	PositionEntity a\piv,x,y,z
	a\dx=dx:a\dy=dy:a\dz=dz
	a\flag$ = flag$
	Return a
End Function

;Add a particle to the scene
Function Add_AshParticle(x#,y#,z#,r=255,g=255,b=255)
	a.ash_particle=New ash_particle
	a\ent=CopyEntity(Ash)
	PositionEntity a\ent,x,y,z
	a\dx=Rnd(-.01,.01)
	a\dy=Rnd(0.01,.07)
	a\dz=Rnd(-.01,.01)
	ScaleSprite a\ent,Rnd(.01,.02),Rnd(.01,.02)
	a\alpha=1
	a\pop=False
	EntityColor a\ent,r,g,b
End Function

;Update all particles
Function Update_AshParticles()
	For a.ash_particle = Each ash_particle
		MoveEntity a\ent,a\dx,a\dy,a\dz
		If EntityY(a\ent)<.3 Then 
			a\dy=-a\dy
			a\dy=a\dy*.62
			a\pop=True
		End If
		a\dy=a\dy-.02
		
		If a\pop Then
			a\alpha=a\alpha-.02
			EntityAlpha a\ent,a\alpha
			If a\alpha<0.05 Then
				FreeEntity a\ent
				Delete a
			End If
		End If
	Next
End Function

;Erase all particles
Function Erase_Particles()
	For a.ash_particle = Each ash_particle
		If a\ent<>0 Then FreeEntity a\ent
	Next
	Delete Each ash_particle
End Function

;this works very similar to the radio, but it has the difference of that you need to toggle between the channels using a key ("E")
Function UpdateRadio()
	
	;radiostate(5) = has the "use the number keys" -message been shown yet (true/false)
	;radiostate(6) = a timer for the "code channel"
	;RadioState(7) = another timer for the "code channel"
	
	;If RadioState(5) = 0 Then 
	;	Msg = "Use keys 1-5 to change the channel"
	;	MsgTimer = 70 * 5
	;	RadioState(5) = 1
	;EndIf
	
	strtemp$ = ""
	
	;x = GraphicWidth - ImageWidth(SelectedItem\itemtemplate\img) ;+ 120
	;y = GraphicHeight - ImageHeight(SelectedItem\itemtemplate\img) ;- 30
	
	;DrawImage(SelectedItem\itemtemplate\img, x, y)
	
	;If SelectedItem\state > 0 Then
	If PlayerRoom\RoomTemplate\Name = "pocketdimension" Or CoffinDistance < 4.0 Then
			;ResumeChannel(RadioCHN(0))
			;If ChannelPlaying(RadioCHN(0)) = False Then RadioCHN(0) = PlaySound(RadioStatic)	
	Else
		Select NTF_RadioCHN
			Case 0 ;randomkanava
					;ResumeChannel(RadioCHN(0))
					;If ChannelPlaying(RadioCHN(0)) = False Then RadioCHN(0) = PlaySound(RadioStatic)
			Case 1 ;h‰lytyskanava
				DebugLog RadioState(1) 
				
				ResumeChannel(RadioCHN(1))
				strtemp = "        WARNING - CONTAINMENT BREACH          "
				If ChannelPlaying(RadioCHN(1)) = False Then
					
					If RadioState(1) => 5 Then
						RadioCHN(1) = PlaySound(RadioSFX(1,1))	
						RadioState(1) = 0
					Else
						RadioState(1)=RadioState(1)+1	
						RadioCHN(1) = PlaySound(RadioSFX(1,0))	
					EndIf
					
				EndIf
				
			Case 2 ;scp-radio
				ResumeChannel(RadioCHN(2))
				strtemp = "        SCP Foundation On-Site Radio          "
				If ChannelPlaying(RadioCHN(2)) = False Then
					RadioState(2)=RadioState(2)+1
					If RadioState(2) = 17 Then RadioState(2) = 1
					If Floor(RadioState(2)/2)=Ceil(RadioState(2)/2) Then ;parillinen, soitetaan normiviesti
						RadioCHN(2) = PlaySound(RadioSFX(2,Int(RadioState(2)/2)))	
					Else ;pariton, soitetaan musiikkia
						RadioCHN(2) = PlaySound(RadioSFX(2,0))
					EndIf
				EndIf
					;EndIf 
			Case 3
				ResumeChannel(RadioCHN(3))
				strtemp = "             EMERGENCY CHANNEL - RESERVED FOR COMMUNICATION IN THE EVENT OF A CONTAINMENT BREACH         "
					;If ChannelPlaying(RadioCHN(3)) = False Then RadioCHN(3) = PlaySound(RadioStatic)
				
				If MTFtimer > 0 Then 
					RadioState(3)=RadioState(3)+Max(Rand(-10,1),0)
					Select RadioState(3)
						Case 100
							RadioCHN(3) = PlaySound(NTF_RadioSFX1(0))
							RadioState(3)=RadioState(3)+1
						Case 800
							RadioCHN(3) = PlaySound(NTF_RadioSFX1(1))
							RadioState(3)=RadioState(3)+1													
						Case 1200
							RadioCHN(3) = PlaySound(NTF_RadioSFX1(2))
							RadioState(3)=RadioState(3)+1	
						Case 1600
							RadioCHN(3) = PlaySound(NTF_RadioSFX1(3))
							RadioState(3)=RadioState(3)+1															
						Case 2000
							RadioCHN(3) = PlaySound(NTF_RadioSFX1(4))	
							RadioState(3)=RadioState(3)+1		
					End Select
				EndIf
			Case 4
					;ResumeChannel(RadioCHN(6)) ;taustalle kohinaa
					;If ChannelPlaying(RadioCHN(6)) = False Then RadioCHN(6) = PlaySound(RadioStatic)									
				
				ResumeChannel(RadioCHN(4))
				If ChannelPlaying(RadioCHN(4)) = False Then 
					If RemoteDoorOn = False And RadioState(8) = False Then
						RadioCHN(4) = PlaySound(NTF_RadioSFX2(0))	
						RadioState(8) = True
					Else
						RadioState(4)=RadioState(4)+Max(Rand(-10,1),0)
						
						Select RadioState(4)
							Case 10
								RadioCHN(4) = PlaySound(NTF_RadioSFX2(1))
								RadioState(4)=RadioState(4)+1													
							Case 100
								RadioCHN(4) = PlaySound(NTF_RadioSFX2(2))
								RadioState(4)=RadioState(4)+1	
							Case 158
								If MTFtimer = 0 Then 
									RadioCHN(4) = PlaySound(NTF_RadioSFX2(3))
									RadioState(4)=RadioState(4)+1
								EndIf
							Case 200
								RadioCHN(4) = PlaySound(NTF_RadioSFX2(4))
								RadioState(4)=RadioState(4)+1
							Case 260
								RadioCHN(4) = PlaySound(NTF_RadioSFX2(5))
								RadioState(4)=RadioState(4)+1
							Case 300
								RadioCHN(4) = PlaySound(NTF_RadioSFX2(6))	
								RadioState(4)=RadioState(4)+1	
							Case 350
								RadioCHN(4) = PlaySound(NTF_RadioSFX2(7))
								RadioState(4)=RadioState(4)+1
							Case 400
								RadioCHN(4) = PlaySound(NTF_RadioSFX2(8))
								RadioState(4)=RadioState(4)+1
							Case 450
								RadioCHN(4) = PlaySound(NTF_RadioSFX2(9))	
								RadioState(4)=RadioState(4)+1		
							Case 600
								RadioCHN(4) = PlaySound(NTF_RadioSFX2(10))	
								RadioState(4)=RadioState(4)+1	
						End Select
					EndIf
				EndIf
				;Case 5
					;ResumeChannel(RadioCHN(5))
					;If ChannelPlaying(RadioCHN(5)) = False Then RadioCHN(5) = PlaySound(RadioStatic)
		End Select 
			;x=x+66
			;y=y+419
		
			;Color (30,30,30)
		
			;If SelectedItem\state <= 100 Then
				;Text (x - 60, y - 20, "BATTERY")
				;For i = 0 To 4
				;	Rect(x, y+8*i, 43 - i * 6, 4, Ceil(SelectedItem\state / 20.0) > 4 - i )
				;Next
			;EndIf	
		
			;SetFont Font3
			;Text(x+60, y, "CHN")						
		
			;If SelectedItem\itemtemplate\tempname = "veryfineradio" Then ;"KOODIKANAVA"
			;	ResumeChannel(RadioCHN(0))
			;	If ChannelPlaying(RadioCHN(0)) = False Then RadioCHN(0) = PlaySound(RadioStatic)
			;	
			;	;radiostate(7)=kuinka mones piippaus menossa
			;	;radiostate(8)=kuinka mones access coden numero menossa
			;	RadioState(6)=RadioState(6) + FPSfactor
			;	temp = Mid(Str(AccessCode),RadioState(8)+1,1)
			;	If RadioState(6)-FPSfactor =< RadioState(7)*50 And RadioState(6)>RadioState(7)*50 Then
			;		PlaySound(RadioBuzz)
			;		RadioState(7)=RadioState(7)+1
			;		If RadioState(7)=>temp Then
			;			RadioState(7)=0
			;			RadioState(6)=-100
			;			RadioState(8)=RadioState(8)+1
			;			If RadioState(8)=4 Then RadioState(8)=0 : RadioState(6)=-200
			;		EndIf
			;	EndIf
			;	
			;	strtemp = ""
			;	For i = 0 To Rand(5, 30)
			;		strtemp = strtemp + Chr(Rand(1,100))
			;	Next
			;	
			;	SetFont Font4
			;	Text(x+97, y+16, Rand(0,9),True,True)
			;	
			;Else
				;For i = 2 To 6
				;	If KeyHit(i) Then
				;		If SelectedItem\state2 <> i-2 Then ;pausetetaan nykyinen radiokanava
				;			PlaySound RadioSquelch
				;			If RadioCHN(Int(SelectedItem\state2)) <> 0 Then PauseChannel(RadioCHN(Int(SelectedItem\state2)))
				;		EndIf
				;		SelectedItem\state2 = i-2
				;		;jos nykyist‰ kanavaa ollaan soitettu, laitetaan jatketaan toistoa samasta kohdasta
				;		If RadioCHN(SelectedItem\state2)<>0 Then ResumeChannel(RadioCHN(SelectedItem\state2))
				;	EndIf
				;Next
				;
				;SetFont Font4
				;Text(x+97, y+16, Int(SelectedItem\state2+1),True,True)
			;EndIf
		
		If KeyHit(KEY_RADIOTOGGLE)
			If RadioCHN(NTF_RadioCHN) <> 0 Then PauseChannel(RadioCHN(NTF_RadioCHN))
			NTF_RadioCHN = NTF_RadioCHN + 1
			PlaySound RadioSquelch
			If NTF_RadioCHN > 4
				NTF_RadioCHN = 0
			EndIf
		EndIf
		
		Color 255,255,255
		
		x% = GraphicWidth - 150
		y% = (GraphicHeight/2) + 250
		
		SetFont Font3
			;If strtemp <> "" Then
			;	strtemp = Right(Left(strtemp, (Int(MilliSecs()/300) Mod Len(strtemp))),10)
			;	Text(x+32, y+33, strtemp)
			;EndIf
			;
		Text x,y,"CHN: "+(NTF_RadioCHN+1)
		SetFont Font1
		
	EndIf
	
	;EndIf
	
	
	
End Function

; function for thread (with single integer param - it is obligatory)
; don't load meshes in thread, if you use RenderWorld function in main loop
Function ThreadFunction ( StartValue% = 0 )
	Repeat
		DrawMovie(movie,0,0,GraphicWidth,GraphicHeight)
		Color 255,255,255
		SetFont Font1%
		Text GraphicWidth/2,GraphicHeight*0.95,"Press (ESC), (Space) or (Left Mouse) to skip",1,1
		Flip 0
	Until MoviePlaying(movie)=False
End Function

Function Update1499Sky()
	PositionEntity NTF_1499Sky, EntityX(Camera),EntityY(Camera),EntityZ(Camera), True
End Function

Function UpdateRoomLights()
	
	;For r.Rooms = Each Rooms
	;	If PlayerRoom = r
	;		For i = 0 To r\MaxLights%
	;			If r\Lights[i] <> 0 Then ShowEntity r\Lights%[i]
	;		Next
	;	Else
	;		For i = 0 To r\MaxLights%
	;			If r\Lights[i] <> 0 Then HideEntity r\Lights%[i]
	;		Next
	;	EndIf
	;Next
	
	For r.Rooms = Each Rooms
		For i = 0 To r\MaxLights%
			If r\Lights%[i]<>0
				If EntityDistance(Camera,r\Lights%[i])<10.0
					If EntityVisible(Camera,r\Lights%[i])
						ShowEntity r\Lights%[i]
					Else
						HideEntity r\Lights%[i]
					EndIf
				Else
					HideEntity r\Lights%[i]
				EndIf
			EndIf
		Next
	Next
	
End Function

Function UpdateMeshLOD()
	
	If NTF_UseLOD%
		TextureLodBias NTF_LODValue#
	Else
		TextureLodBias 0.0
	EndIf
	
End Function

Type MapProps
	Field obj%
End Type

Function UpdateMapProps()
	
	For a.MapProps = Each MapProps
		If a\obj<>0
			If EntityDistance(a\obj,Camera)<10.0
				If EntityVisible(a\obj,Camera)
				;If EntityInView(a\obj,Camera)
					ShowEntity a\obj
				Else
					HideEntity a\obj
				EndIf
			Else
				HideEntity a\obj
			EndIf
		EndIf
	Next
	
End Function

Function PlayTestSound(playing%)
	
	If playing% = True
		If MenuTestSound% = 0 Then
			MenuTestSound% = LoadSound_Strict("NineTailedFoxMod\SFX\Menu_Test.ogg")
		EndIf
		If (Not ChannelPlaying(MenuTestSoundCHN))
			MenuTestSoundCHN = PlaySound(MenuTestSound%)
		EndIf
		ChannelVolume MenuTestSoundCHN,SFXVolume
	Else
		FreeSound MenuTestSound% : MenuTestSound% = 0
		MenuTestSoundCHN = 0
	EndIf
	
End Function

Function LoadAchievements()
	
	If FileType("NineTailedFoxMod\gamedata.dat")<>1
		DebugLog "WARNING: 'NineTailedFoxMod\gamedata.dat' not found! Creating new file..."
		Local file = WriteFile("NineTailedFoxMod\gamedata.dat")
		For i = 0 To MAXACHIEVEMENTS-1
			WriteByte file,0
			WriteByte file,0
			Achievements(i)=0
			AchvProgress(i)=0
		Next
		CloseFile(file)
	Else
		file = ReadFile("NineTailedFoxMod\gamedata.dat")
		For i = 0 To MAXACHIEVEMENTS-1
			Achievements(i)=ReadByte(file)
			AchvProgress(i)=ReadByte(file)
		Next
		CloseFile(file)
	EndIf
	
End Function

Function SaveAchievements()
	
	If FileType("NineTailedFoxMod\gamedata.dat")<>1
		RuntimeError "ERROR: 'NineTailedFoxMod\gamedata.dat' not found! Please restart the game to fix this issue."
	Else
		Local file = OpenFile("NineTailedFoxMod\gamedata.dat")
		For i = 0 To MAXACHIEVEMENTS-1
			WriteByte file,Achievements(i)
			WriteByte file,AchvProgress(i)
		Next
		CloseFile(file)
	EndIf
	
End Function

Function PlayMTFSFX(sfx$,n.NPCs,min_amount%=0,max_amount%=0)
	Local random% = Rand(min_amount%,max_amount%)
	
	;If ChannelPlaying(n\SoundCHN) Then StopChannel(n\SoundCHN)
	If n\Sound <> 0 Then FreeSound n\Sound : n\Sound=0
	
	If n <> Null
		If n\NPCID% = 1
			If min_amount% = 0 And max_amount% = 0
				n\Sound = LoadSound_Strict("NineTailedFoxMod\SFX\MTF\Other_GasMask\1_"+sfx$+".ogg")
			Else
				n\Sound = LoadSound_Strict("NineTailedFoxMod\SFX\MTF\Other_GasMask\1_"+(sfx$+random%)+".ogg")
			EndIf
			n\SoundChn = PlaySound2(n\Sound, Camera, n\Collider, 8.0)
		ElseIf n\NPCID% = 2
			If min_amount% = 0 And max_amount% = 0
				n\Sound = LoadSound_Strict("NineTailedFoxMod\SFX\MTF\Other_GasMask\2_"+sfx$+".ogg")
			Else
				n\Sound = LoadSound_Strict("NineTailedFoxMod\SFX\MTF\Other_GasMask\2_"+(sfx$+random%)+".ogg")
			EndIf
			n\SoundChn = PlaySound2(n\Sound, Camera, n\Collider, 8.0)
		Else
			If min_amount% = 0 And max_amount% = 0
				n\Sound = LoadSound_Strict("SFX\MTF\"+sfx$+".ogg")
			Else
				n\Sound = LoadSound_Strict("SFX\MTF\"+(sfx$+random%)+".ogg")
			EndIf
			n\SoundChn = PlaySound2(n\Sound, Camera, n\Collider, 8.0)
		EndIf
	EndIf
	
End Function

Function DrawScrollBar#(x, y, width, height, barx, bary, barwidth, barheight, bar#, dir = 0)
	;0 = vaakasuuntainen, 1 = pystysuuntainen
	
	Local MouseSpeedX = MouseXSpeed()
	Local MouseSpeedY = MouseYSpeed()
	
	Color(0, 0, 0)
	;Rect(x, y, width, height)
	Button(barx, bary, barwidth, barheight, "")
	
	If dir = 0 Then ;vaakasuunnassa
		If height > 10 Then
			Color 250,250,250
			Rect(barx + barwidth / 2, bary + 5*MenuScale, 2*MenuScale, barheight - 10)
			Rect(barx + barwidth / 2 - 3*MenuScale, bary + 5*MenuScale, 2*MenuScale, barheight - 10)
			Rect(barx + barwidth / 2 + 3*MenuScale, bary + 5*MenuScale, 2*MenuScale, barheight - 10)
		EndIf
	Else ;pystysuunnassa
		If width > 10 Then
			Color 250,250,250
			Rect(barx + 4*MenuScale, bary + barheight / 2, barwidth - 10*MenuScale, 2*MenuScale)
			Rect(barx + 4*MenuScale, bary + barheight / 2 - 3*MenuScale, barwidth - 10*MenuScale, 2*MenuScale)
			Rect(barx + 4*MenuScale, bary + barheight / 2 + 3*MenuScale, barwidth - 10*MenuScale, 2*MenuScale)
		EndIf
	EndIf
	
	If MouseDown1 Then
		If MouseX()>barx And MouseX()<barx+barwidth Then
			If MouseY()>bary And MouseY()<bary+barheight Then
				If dir = 0 Then
					Return Min(Max(bar + MouseSpeedX / Float(width - barwidth), 0), 1)
				Else
					Return Min(Max(bar + MouseSpeedY / Float(height - barheight), 0), 1)
				End If				
			EndIf
		EndIf
	End If
	
	Return bar
	
End Function

Function Button%(x,y,width,height,txt$, disabled%=False)
	Local Pushed = False
	
	Color ClrR, ClrG, ClrB
	If Not disabled Then 
		If MouseX() > x And MouseX() < x+width Then
			If MouseY() > y And MouseY() < y+height Then
				If MouseDown1 Then
					Pushed = True
					Color ClrR*0.6, ClrG*0.6, ClrB*0.6
				Else
					Color Min(ClrR*1.2,255),Min(ClrR*1.2,255),Min(ClrR*1.2,255)
				EndIf
			EndIf
		EndIf
	EndIf
	
	If Pushed Then 
		Rect x,y,width,height
		Color 133,130,125
		Rect x+1*MenuScale,y+1*MenuScale,width-1*MenuScale,height-1*MenuScale,False	
		Color 10,10,10
		Rect x,y,width,height,False
		Color 250,250,250
		Line x,y+height-1*MenuScale,x+width-1*MenuScale,y+height-1*MenuScale
		Line x+width-1*MenuScale,y,x+width-1*MenuScale,y+height-1*MenuScale
	Else
		Rect x,y,width,height
		Color 133,130,125
		Rect x,y,width-1*MenuScale,height-1*MenuScale,False	
		Color 250,250,250
		Rect x,y,width,height,False
		Color 10,10,10
		Line x,y+height-1,x+width-1,y+height-1
		Line x+width-1,y,x+width-1,y+height-1		
	EndIf
	
	Color 255,255,255
	If disabled Then Color 70,70,70
	Text x+width/2, y+height/2-1*MenuScale, txt, True, True
	
	Color 0,0,0
	
	If Pushed And MouseHit1 Then PlaySound ButtonSFX : Return True
End Function

Type NPCHitBoxes
	Field obj%
	Field HitType
End Type

Function CreateNPCHitBox.NPCHitBoxes(n.NPCs,HitType%,bone1%,bone2%=0)
	Local a.NPCHitBoxes = New NPCHitBoxes
	
	a\obj% = CreateCube(bone1%)
	EntityFX a\obj%,FE_WIRE
	a\HitType = HitType
	
	Return a
End Function

Function ChangeZone(newzone%)
	
	SZL_SaveZone(NTF_CurrZone%)
	
	DrawLoading(0)
	
	SoundVolume NTF_zoneChangeSFX,SFXVolume#
	PlaySound NTF_ZoneChangeSFX
	
	NTF_CurrZone% = newzone%
	
	If FileType(SavePath + CurrSave + "\_z"+newzone%+".SZL")<>1
		SZL_CreateZone(newzone%)
	Else
		SZL_LoadZone(newzone%)
	EndIf
	
	DrawLoading(90)
	
	ClosestButton = 0
	
	For r.Rooms = Each Rooms
		If NTF_CurrZone% = 3
			Select Lower(r\RoomTemplate\Name)
				Case "checkpoint2"
					MTFrooms[0]=r
				Case "room2gs"
					MTFrooms[1]=r	
				Case "room2ccont"
					MTFrooms[2]=r	
				Case "room2poffices"
					MTFrooms[3]=r	
				Case "room2offices"
					MTFrooms[4]=r	
				Case "room2offices2"
					MTFrooms[5]=r	
				Case "room3servers2"
					MTFrooms[6]=r		
			End Select
		ElseIf NTF_CurrZone% = 2
			Select Lower(r\RoomTemplate\Name)
				Case "checkpoint2"
					MTFrooms[0]=r
				Case "checkpoint1"
					MTFrooms[1]=r	
				Case "room106"
					MTFrooms[2]=r	
				Case "room079"
					MTFrooms[3]=r	
				Case "coffin"
					MTFrooms[4]=r	
				Case "room049"
					MTFrooms[5]=r	
				Case "room035"
					MTFrooms[6]=r		
			End Select
		ElseIf NTF_CurrZone% = 1
			Select Lower(r\RoomTemplate\Name)
				Case "checkpoint1"
					MTFrooms[0]=r
				Case "room205"
					MTFrooms[1]=r	
				Case "room1123"
					MTFrooms[2]=r	
				Case "roompj"
					MTFrooms[3]=r	
				Case "room178"
					MTFrooms[4]=r	
				Case "room2scps2"
					MTFrooms[5]=r	
				Case "start"
					MTFrooms[6]=r		
			End Select
		EndIf
	Next
	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ = "checkpoint1" Or r\RoomTemplate\Name$ = "checkpoint2"
			PlayerRoom = r
			Exit
		EndIf
	Next
	
	For i% = 0 To 70
		FPSfactor = 1.0
		FlushKeys()
		MovePlayer()
		UpdateDoors()
		UpdateNPCs()
		UpdateWorld()
		;Cls
		DrawLoading(80+Int(Float(i)*0.27))
	Next
	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ <> "checkpoint1" And r\RoomTemplate\Name$ <> "checkpoint2"
			DebugLog "FORCED 173 TELEPORTATION TO: "+r\roomtemplate\name
			PositionEntity Curr173\Collider, EntityX(r\obj,True), EntityY(r\obj,True)+0.5,EntityZ(r\obj,True)
			ResetEntity Curr173\Collider
			Exit
		EndIf
	Next
	
	DropSpeed = 0
	
	If PlayerRoom = Null Then RuntimeError "Player Room not found"
	
	DrawLoading(100)
	
	;If temp
	;	Curr173\Idle = False
	;EndIf
	
End Function

Function SZL_SaveZone(c_zone%)
	
	CreateDir(SavePath + CurrSave + "\")
	
	Local f% = WriteFile(SavePath + CurrSave + "\_z"+c_zone%+".SZL")
	
	temp = 0
	For  n.NPCs = Each NPCs
		If n\NPCtype <> NPCtypeMTF2
			If n <> Curr173 And n <> Curr106 And n <> Curr096
				temp = temp + 1
			EndIf
		EndIf
	Next	
	
	WriteInt f, temp
	For n.NPCs = Each NPCs
		If n\NPCtype <> NPCtypeMTF2
			If n <> Curr173 And n <> Curr106 And n <> Curr096
				WriteByte f, n\NPCtype
				WriteFloat f, EntityX(n\collider,True)
				WriteFloat f, EntityY(n\collider,True)
				WriteFloat f, EntityZ(n\collider,True)
				
				WriteFloat f, EntityPitch(n\collider)
				WriteFloat f, EntityYaw(n\collider)
				WriteFloat f, EntityRoll(n\collider)
				
				WriteFloat f, n\state
				WriteFloat f, n\state2
				WriteFloat f, n\state3
				WriteInt f, n\prevstate
				
				WriteByte f, n\idle
				WriteFloat f, n\lastDist
				WriteInt f, n\lastSeen
				
				WriteInt f, n\currspeed
				
				WriteFloat f, n\angle
				
				WriteFloat f, n\reload
				
				WriteInt f, n\ID
				If n\target <> Null Then
					WriteInt f, n\target\id		
				Else
					WriteInt f, 0
				EndIf
				
				WriteFloat f, n\enemyX
				WriteFloat f, n\enemyY
				WriteFloat f, n\enemyz
				
				WriteString f, n\texture
				
				WriteFloat f, AnimTime(n\obj)
				
				WriteInt f,n\HP%
				WriteInt f,n\CurrHP%
				WriteInt f,n\NPCID%
			EndIf
		EndIf
	Next
	
	temp = 0
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ <> "checkpoint1" And r\RoomTemplate\Name$ <> "checkpoint2"
			temp=temp+1
		EndIf
	Next	
	WriteInt f, temp	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ <> "checkpoint1" And r\RoomTemplate\Name$ <> "checkpoint2"
			WriteInt f, r\roomtemplate\id
			WriteInt f, r\angle
			WriteFloat f, r\x
			WriteFloat f, r\y
			WriteFloat f, r\z
			
			WriteByte f, r\found
			
			WriteInt f, r\zone
			
			If PlayerRoom = r Then 
				WriteByte f, 1
			Else 
				WriteByte f, 0
			EndIf
			
			For i = 0 To 11
				If r\npc[i]=Null Then
					WriteInt f, 0
				Else
					WriteInt f, r\npc[i]\id
				EndIf
			Next
			
			For i=0 To 10
				If r\Levers[i]<>0 Then
					If EntityPitch(r\Levers[i],True) > 0 Then ;p‰‰ll‰
						WriteByte(f,1)
					Else
						WriteByte(f,0)
					EndIf	
				EndIf
			Next
			WriteByte(f,2)
			
			
			If r\grid=Null Then ;this room doesn't have a grid
				WriteByte(f,0)
			Else ;this room has a grid
				WriteByte(f,1)
				For y=0 To gridsz-1
					For x=0 To gridsz-1
						WriteByte(f,r\grid\grid[x+(y*gridsz)])
						WriteByte(f,r\grid\angles[x+(y*gridsz)])
					Next
				Next
			EndIf
			
			If r\fr=Null Then ;this room doesn't have a forest
				WriteByte(f,0)
			Else ;this room has a forest
				WriteByte(f,1)
				For y=0 To gridsize-1
					For x=0 To gridsize-1
						WriteByte(f,r\fr\grid[x+(y*gridsize)])
					Next
				Next
				WriteFloat f,EntityX(r\fr\Forest_Pivot,True)
				WriteFloat f,EntityY(r\fr\Forest_Pivot,True)
				WriteFloat f,EntityZ(r\fr\Forest_Pivot,True)
			EndIf
		EndIf
	Next
	
	temp = 0
	For do.Doors = Each Doors
		temp = temp+1
	Next	
	WriteInt f, temp	
	For do.Doors = Each Doors
		WriteFloat f, EntityX(do\frameobj,True)
		WriteFloat f, EntityY(do\frameobj,True)
		WriteFloat f, EntityZ(do\frameobj,True)
		WriteByte f, do\open
		WriteFloat f, do\openstate
		WriteByte f, do\locked
		WriteByte f, do\AutoClose
		
		WriteFloat f, EntityX(do\obj, True)
		WriteFloat f, EntityZ(do\obj, True)
		
		If do\obj2 <> 0 Then
			WriteFloat f, EntityX(do\obj2, True)
			WriteFloat f, EntityZ(do\obj2, True)
		Else
			WriteFloat f, 0.0
			WriteFloat f, 0.0
		End If
		
		WriteFloat f, do\timer
		WriteFloat f, do\timerstate	
	Next
	
	temp = 0
	For e.events = Each Events
		If e\eventName <> "checkpoint"
			temp=temp+1
		EndIf
	Next	
	WriteInt f, temp
	For e.events = Each Events
		If e\eventName <> "checkpoint"
			WriteString f, e\eventName		
			WriteFloat f, e\eventstate
			WriteFloat f, e\eventstate2	
			WriteFloat f, e\eventstate3	
			WriteFloat f, EntityX(e\room\obj)
			WriteFloat f, EntityZ(e\room\obj)
		EndIf
	Next
	
	temp = 0
	For it.items = Each Items
		If it\Picked = False	
			temp=temp+1
		EndIf
	Next
	WriteInt f, temp
	For it.items = Each Items
		If it\Picked = False
			WriteString f, it\itemtemplate\name
			WriteString f, it\itemtemplate\tempName
			
			WriteString f, it\name
			
			WriteFloat f, EntityX(it\obj, True)
			WriteFloat f, EntityY(it\obj, True)
			WriteFloat f, EntityZ(it\obj, True)
			
			WriteByte f, it\r
			WriteByte f, it\g
			WriteByte f, it\b
			WriteFloat f, it\a
			
			WriteFloat f, EntityPitch(it\obj)
			WriteFloat f, EntityYaw(it\obj)
			
			WriteFloat f, it\state
			WriteByte f, it\Picked
			
			If SelectedItem = it Then WriteByte f, 1 Else WriteByte f, 0
			Local ItemFound% = False
			For i = 0 To MaxItemAmount - 1
				If Inventory(i) = it Then ItemFound = True : Exit
			Next
			If ItemFound Then WriteByte f, i Else WriteByte f, 66
			
			If it\itemtemplate\isAnim<>0 Then
				WriteFloat f, AnimTime(it\obj)
			EndIf
			WriteByte f,it\invSlots
			WriteInt f,it\ID
			If it\itemtemplate\invimg=it\invimg Then WriteByte f,0 Else WriteByte f,1
		EndIf
	Next
	
	temp=0
	For it.items = Each Items
		If it\invSlots>0 Then temp=temp+1
	Next
	
	WriteInt f,temp
	
	For it.items = Each Items
		;OtherInv
		If it\invSlots>0 Then
			WriteInt f,it\ID
			For i=0 To it\invSlots-1
				If it\SecondInv[i] <> Null Then
					WriteInt f, it\SecondInv[i]\ID
				Else
					WriteInt f, -1
				EndIf
			Next
		EndIf
		;OtherInv End
	Next
	
	DebugLog "Zone Saved: "+c_zone%
	
	CloseFile(f)
	
End Function

Function SZL_LoadZone(c_zone%)
	
	Local f% = ReadFile(SavePath + CurrSave + "\_z"+c_zone%+".SZL")
	
	For n.NPCs = Each NPCs
		If n\NPCtype <> NPCtypeMTF2
			If n <> Curr173 And n <> Curr106 And n <> Curr096
				RemoveNPC(n)
			EndIf
		EndIf
	Next
	
	temp = ReadInt(f)
	For i = 1 To temp
		Local NPCtype% = ReadByte(f)
		x = ReadFloat(f)
		y = ReadFloat(f)
		z = ReadFloat(f)
		
		n.NPCs = CreateNPC(NPCtype, x, y+0.05, z)
		;Select NPCtype
		;	Case NPCtype173
		;		Curr173 = n
		;	Case NPCtypeOldMan
		;		Curr106 = n
		;	Case NPCtype096
		;		Curr096 = n
		;End Select
		
		x = ReadFloat(f)
		y = ReadFloat(f)
		z = ReadFloat(f)
		RotateEntity(n\collider, x, y, z)
		
		n\state = ReadFloat(f)
		n\state2 = ReadFloat(f)	
		n\state3 = ReadFloat(f)			
		n\prevstate = ReadInt(f)
		
		n\idle = ReadByte(f)
		n\lastDist = ReadFloat(f)
		n\lastSeen = ReadInt(f)
		
		n\currspeed = ReadInt(f)
		n\angle = ReadFloat(f)
		n\reload = ReadFloat(f)
		
		n\id = ReadInt(f)
		n\targetid = ReadInt(f)
		
		n\enemyX = ReadFloat(f)
		n\enemyY = ReadFloat(f)
		n\enemyz = ReadFloat(f)
		
		n\texture = ReadString(f)
		If n\texture <> "" Then
			tex = LoadTexture_Strict (n\texture)
			EntityTexture n\obj, tex
		EndIf
		
		Local frame# = ReadFloat(f)
		Select NPCtype
			Case NPCtypeOldMan, NPCtypeD, NPCtype096, NPCtypeMTF, NPCtypeGuard, NPCtype049, NPCtypeZombie
				SetAnimTime(n\obj, frame)
		End Select
		
		n\HP% = ReadInt(f)
		n\CurrHP% = ReadInt(f)
		n\NPCID% = ReadInt(f)
		
	Next
	
	For n.npcs = Each NPCs
		If n\targetid <> 0 Then
			For n2.npcs = Each NPCs
				If n2<>n Then
					If n2\id = n\targetid Then n\target = n2
				EndIf
			Next
		EndIf
	Next
	
	For wp.WayPoints = Each WayPoints
		If wp\room\RoomTemplate\Name$ <> "checkpoint1" And wp\room\RoomTemplate\Name$ <> "checkpoint2"
			RemoveWaypoint(wp)
		EndIf
	Next
	For twp.TempWayPoints = Each TempWayPoints
		Delete twp
	Next
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ <> "checkpoint1" And r\RoomTemplate\Name$ <> "checkpoint2"
			For i = 0 To 19
				If r\Lights[i]<> 0 Then FreeEntity r\Lights[i] : r\Lights[i]=0
			Next
			FreeEntity r\obj% : r\obj%=0
			Delete r
		EndIf
	Next
	For e.Events = Each Events
		If e\eventName <> "checkpoint"
			RemoveEvent(e)
		EndIf
	Next
	For d.Doors = Each Doors
		RemoveDoor(d)
	Next
	For pr.Props = Each Props
		Delete pr
	Next
	For scr.Screens = Each Screens
		Delete scr
	Next
	For sc.securitycams = Each SecurityCams
		Delete sc
	Next
	For em.emitters = Each Emitters
		Delete em
	Next
	For rt.RoomTemplates = Each RoomTemplates
		rt\obj = 0
	Next
	
	DrawLoading(15)
	
	;Dim MapRoomID%(ROOM4 + 1)
	
	temp = ReadInt(f)
	For i = 1 To temp
		Local roomtemplateID% = ReadInt(f)
		Local angle% = ReadInt(f)
		x = ReadFloat(f)
		y = ReadFloat(f)
		z = ReadFloat(f)
		
		found = ReadByte(f)
		
		level = ReadInt(f)
		
		temp2 = ReadByte(f)		
		
		For rt.roomtemplates = Each RoomTemplates
			If rt\id = roomtemplateID Then
				r.Rooms = CreateRoom(level, rt\shape, x, y, z, rt\name)
				TurnEntity(r\obj, 0, angle, 0)
				r\angle = angle
				r\found = found
				Exit
			End If
		Next
		
		If temp2 = 1 Then PlayerRoom = r.Rooms
		
		For x = 0 To 11
			id = ReadInt(f)
			If id > 0 Then
				For n.npcs = Each NPCs
					If n\id = id Then r\NPC[x]=n : Exit
				Next
			EndIf
		Next
		
		For x=0 To 11
			id = ReadByte(f)
			If id=2 Then
				Exit
			Else If id=1 Then
				RotateEntity(r\Levers[x], 78, EntityYaw(r\Levers[x]), 0)
			Else
				RotateEntity(r\Levers[x], -78, EntityYaw(r\Levers[x]), 0)
			EndIf
		Next
		
		If ReadByte(f)=1 Then ;this room has a grid
			If r\grid<>Null Then ;remove the old grid content
				For x=0 To gridsz-1
					For y=0 To gridsz-1
						If r\grid\Entities[x+(y*gridsz)]<>0 Then
							FreeEntity r\grid\Entities[x+(y*gridsz)]
							r\grid\Entities[x+(y*gridsz)]=0
						EndIf
						If r\grid\waypoints[x+(y*gridsz)]<>Null Then
							RemoveWaypoint(r\grid\waypoints[x+(y*gridsz)])
							r\grid\waypoints[x+(y*gridsz)]=Null
						EndIf
					Next
				Next
				For x=0 To 5
					If r\grid\Meshes[x]<>0 Then
						FreeEntity r\grid\Meshes[x]
						r\grid\Meshes[x]=0
					EndIf
				Next
				Delete r\grid
			EndIf
			r\grid=New Grids
			For y=0 To gridsz-1
				For x=0 To gridsz-1
					r\grid\grid[x+(y*gridsz)]=ReadByte(f)
					r\grid\angles[x+(y*gridsz)]=ReadByte(f)
					;get only the necessary data, make the event handle the meshes and waypoints separately
				Next
			Next
		EndIf
		
		If ReadByte(f)=1 Then ;this room has a forest
			If r\fr<>Null Then ;remove the old forest
				DestroyForest(r\fr)
			Else
				r\fr=New Forest
			EndIf
			For y=0 To gridsize-1
				Local sssss$ = ""
				For x=0 To gridsize-1
					r\fr\grid[x+(y*gridsize)]=ReadByte(f)
					sssss=sssss+Str(r\fr\grid[x+(y*gridsize)])
				Next
				DebugLog sssss
			Next
			lx# = ReadFloat(f)
			ly# = ReadFloat(f)
			lz# = ReadFloat(f)
			PlaceForest(r\fr,lx,ly,lz,r)
		ElseIf r\fr<>Null Then ;remove the old forest
			DestroyForest(r\fr)
			Delete r\fr
		EndIf
	Next
	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ = "checkpoint1" Or r\RoomTemplate\Name$ = "checkpoint2"
			FillRoom(r)
			DebugLog "Filled Room"+r\RoomTemplate\Name$
		EndIf
	Next
	
	DrawLoading(40)
	
	Local spacing# = 8.0
	For lvl = 0 To 0
		For y = MapHeight - 1 To 1 Step - 1
			
			If y < MapHeight/3+1 Then
				temp=0
			ElseIf y < MapHeight*(2.0/3.0)-1
				temp=2
			Else
				temp=0
			EndIf
			
			For x = 1 To MapWidth - 2
				If MapTemp(x, y) > 0 Then
					If (Floor((x + y) / 2.0) = Ceil((x + y) / 2.0)) Then
						If MapTemp(x + 1, y) Then
							CreateDoor(lvl, x * spacing + spacing / 2.0, 0, y * spacing, 90, Null, Max(Rand(-3, 1), 0), temp)
						EndIf
						
						If MapTemp(x - 1, y) Then
							CreateDoor(lvl, x * spacing - spacing / 2.0, 0, y * spacing, 90, Null, Max(Rand(-3, 1), 0), temp)
						EndIf
						
						If MapTemp(x, y + 1) Then
							CreateDoor(lvl, x * spacing, 0, y * spacing + spacing / 2.0, 0, Null, Max(Rand(-3, 1), 0), temp)
						EndIf
						
						If MapTemp(x, y - 1)Then
							CreateDoor(lvl, x * spacing, 0, y * spacing - spacing / 2.0, 0, Null, Max(Rand(-3, 1), 0), temp)
						EndIf
					End If
				EndIf
			Next
		Next
	Next
	
	DrawLoading(50)
	
	temp = ReadInt (f)
	
	For i = 1 To temp
		x = ReadFloat(f)
		y = ReadFloat(f)
		z = ReadFloat(f)
		
		Local open% = ReadByte(f)
		Local openstate# = ReadFloat(f)
		Local locked% = ReadByte(f)
		Local autoclose% = ReadByte(f)
		
		Local objX# = ReadFloat(f)
		Local objZ# = ReadFloat(f)
		
		Local obj2X# = ReadFloat(f)
		Local obj2Z# = ReadFloat(f)
		
		Local timer% = ReadFloat(f)
		Local timerstate# = ReadFloat(f)
		
		For do.Doors = Each Doors
			If EntityX(do\frameobj,True) = x And EntityY(do\frameobj,True) = y And EntityZ(do\frameobj,True) = z Then
				do\open = open
				do\openstate = openstate
				do\locked = locked
				do\AutoClose = autoclose
				do\timer = timer
				do\timerstate = timerstate
				
				PositionEntity(do\obj, objX, y, objZ, True)
				If do\obj2 <> 0 Then PositionEntity(do\obj2, obj2X, y, obj2Z, True)
				Exit
			End If
		Next		
	Next
	
	InitWayPoints()
	
	DrawLoading(70)
	
	temp = ReadInt(f)
	For i = 1 To temp
		e.Events = New Events
		e\EventName = ReadString(f)
		
		e\EventState =ReadFloat(f)
		e\EventState2 =ReadFloat(f)		
		e\EventState3 =ReadFloat(f)
		x = ReadFloat(f)
		z = ReadFloat(f)
		For  r.Rooms = Each Rooms
			If EntityX(r\obj) = x And EntityZ(r\obj) = z Then
				e\room = r
				Exit
			EndIf
		Next	
	Next
	
	Local it.Items
	For it.Items = Each Items
		If it\Picked = False
			RemoveItem(it)
		EndIf
	Next
	
	temp = ReadInt(f)
	For i = 1 To temp
		Local ittName$ = ReadString(f)
		Local tempName$ = ReadString(f)
		Local Name$ = ReadString(f)
		
		x = ReadFloat(f)
		y = ReadFloat(f)
		z = ReadFloat(f)
		
		red = ReadByte(f)
		green = ReadByte(f)
		blue = ReadByte(f)		
		a = ReadFloat(f)
		
		it.Items = CreateItem(ittName, tempName, x, y+0.05, z, red,green,blue,a)
		it\name = Name
		
		EntityType it\obj, HIT_ITEM
		
		x = ReadFloat(f)
		y = ReadFloat(f)
		RotateEntity(it\obj, x, y, 0)
		
		it\state = ReadFloat(f)
		it\Picked = ReadByte(f)
		If it\Picked Then HideEntity(it\obj)
		
		nt = ReadByte(f)
		If nt = True Then SelectedItem = it
		
		nt = ReadByte(f)
		If nt < 66 Then Inventory(nt) = it
		
		For itt.ItemTemplates = Each ItemTemplates
			If (itt\tempname = tempName) And (itt\name = ittName) Then
				If itt\isAnim<>0 Then SetAnimTime it\obj,ReadFloat(f) : Exit
			EndIf
		Next
		it\invSlots = ReadByte(f)
		it\ID = ReadInt(f)
		
		If it\ID>LastItemID Then LastItemID=it\ID
		
		If ReadByte(f)=0 Then
			it\invimg=it\itemtemplate\invimg
		Else
			it\invimg=it\itemtemplate\invimg2
		EndIf
	Next
	
	Local o_i%
	
	temp = ReadInt(f)
	For i=1 To temp
		;OtherInv
		o_i=ReadInt(f)
		
		For ij.Items = Each Items
			If ij\ID=o_i Then it.Items=ij : Exit
		Next
		For j%=0 To it\invSlots-1
			o_i=ReadInt(f)
			DebugLog "secondinv "+o_i
			If o_i<>-1 Then
				For ij.Items=Each Items
					If ij\ID=o_i Then
						it\SecondInv[j]=ij
						Exit
					EndIf
				Next
			EndIf
		Next
		;OtherInv End
	Next
	
	For do.Doors = Each Doors
		If do\room <> Null Then
			dist# = 20.0
			Local closestroom.Rooms
			For r.Rooms = Each Rooms
				dist2# = EntityDistance(r\obj, do\obj)
				If dist2 < dist Then
					dist = dist2
					closestroom = r.Rooms
				EndIf
			Next
			do\room = closestroom
		EndIf
	Next
	
	CloseFile f
	
	For r.Rooms = Each Rooms
		r\Adjacent[0]=Null
		r\Adjacent[1]=Null
		r\Adjacent[2]=Null
		r\Adjacent[3]=Null
		For r2.Rooms = Each Rooms
			If r<>r2 Then
				If r2\z=r\z Then
					If (r2\x)=(r\x+8.0) Then
						r\Adjacent[0]=r2
						;If r\AdjDoor[0] = Null Then r\AdjDoor[0] = r2\AdjDoor[2]
					ElseIf (r2\x)=(r\x-8.0)
						r\Adjacent[2]=r2
						;If r\AdjDoor[2] = Null Then r\AdjDoor[2] = r2\AdjDoor[0]
					EndIf
				ElseIf r2\x=r\x Then
					If (r2\z)=(r\z-8.0) Then
						r\Adjacent[1]=r2
						;If r\AdjDoor[1] = Null Then r\AdjDoor[1] = r2\AdjDoor[3]
					ElseIf (r2\z)=(r\z+8.0)
						r\Adjacent[3]=r2
						;If r\AdjDoor[3] = Null Then r\AdjDoor[3] = r2\AdjDoor[1]
					EndIf
				EndIf
			EndIf
			If (r\Adjacent[0]<>Null) And (r\Adjacent[1]<>Null) And (r\Adjacent[2]<>Null) And (r\Adjacent[3]<>Null) Then Exit
		Next
		
		For do.Doors = Each Doors
			If (do\keycard = 0) And (do\code="") Then
				If EntityZ(do\frameobj,True)=r\z Then
					If EntityX(do\frameobj,True)=r\x+4.0 Then
						r\AdjDoor[0] = do
					ElseIf EntityX(do\frameobj,True)=r\x-4.0 Then
						r\AdjDoor[2] = do
					EndIf
				ElseIf EntityX(do\frameobj,True)=r\x Then
					If EntityZ(do\frameobj,True)=r\z+4.0 Then
						r\AdjDoor[3] = do
					ElseIf EntityZ(do\frameobj,True)=r\z-4.0 Then
						r\AdjDoor[1] = do
					EndIf
				EndIf
			EndIf
		Next
	Next
	
	For d.Doors = Each Doors
		EntityParent(d\obj, 0)
		If d\obj2 > 0 Then EntityParent(d\obj2, 0)
		If d\frameobj > 0 Then EntityParent(d\frameobj, 0)
		If d\buttons[0] > 0 Then EntityParent(d\buttons[0], 0)
		If d\buttons[1] > 0 Then EntityParent(d\buttons[1], 0)
		
	Next
	
	For sc.SecurityCams = Each SecurityCams
		sc\angle = EntityYaw(sc\obj) + sc\angle
		EntityParent(sc\obj, 0)
	Next
	
	For rt.RoomTemplates = Each RoomTemplates
		If rt\obj <> 0 Then FreeEntity(rt\obj) : rt\obj = 0
	Next
	
	DrawLoading(80)
	
	DebugLog "Zone Loaded: "+zone%
	
End Function

Function SZL_CreateZone(c_zone%)
	Local r.Rooms
	
	For wp.WayPoints = Each WayPoints
		If wp\room\RoomTemplate\Name$ <> "checkpoint1" And wp\room\RoomTemplate\Name$ <> "checkpoint2"
			RemoveWaypoint(wp)
		EndIf
	Next
	For twp.TempWayPoints = Each TempWayPoints
		Delete twp
	Next	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ <> "checkpoint1" And r\RoomTemplate\Name$ <> "checkpoint2"
			For i = 0 To 19
				If r\Lights[i]<> 0 Then FreeEntity r\Lights[i] : r\Lights[i]=0
			Next
			FreeEntity r\obj% : r\obj%=0
			Delete r
		EndIf
	Next
	For e.Events = Each Events
		If e\eventName <> "checkpoint"
			RemoveEvent(e)
		EndIf
	Next
	For d.Doors = Each Doors
		RemoveDoor(d)
	Next
	For n.NPCs = Each NPCs
		If n\NPCtype <> NPCtypeMTF2
			If n <> Curr173 And n <> Curr106 And n <> Curr096
				RemoveNPC(n)
			EndIf
		EndIf
	Next
	Local it.Items
	For it.Items = Each Items
		If it\Picked = False
			RemoveItem(it)
		EndIf
	Next
	For pr.Props = Each Props
		Delete pr
	Next
	For scr.Screens = Each Screens
		Delete scr
	Next
	For sc.securitycams = Each SecurityCams
		Delete sc
	Next
	For em.emitters = Each Emitters
		Delete em
	Next
	For rt.RoomTemplates = Each RoomTemplates
		rt\obj = 0
	Next
	
	DrawLoading(10)
	
	;Dim MapRoomID%(ROOM4 + 1)
	
	temp = 0
	;Local r.Rooms
	Local spacing# = 8.0
	For y = MapHeight - 1 To 1 Step - 1
		
		;zone% = GetZone(y)
		
		If y < MapHeight/3+1 Then
			zone=3
		ElseIf y < MapHeight*(2.0/3.0);-1
			zone=2
		Else
			zone=1
		EndIf
		
		For x = 1 To MapWidth - 2
			;If MapTemp(x, y) = 255 Then
			
			;ElseIf MapTemp(x, y) > 0
			If MapTemp(x, y) > 0 And MapTemp(x, y) <> 255
				
				temp = Min(MapTemp(x + 1, y),1) + Min(MapTemp(x - 1, y),1) + Min(MapTemp(x, y + 1),1) + Min(MapTemp(x, y - 1),1)
				
				Select temp
					Case 1
						If zone% = c_zone%
							r = CreateRoom(zone, ROOM1, x * 8, 0, y * 8, MapName(x, y))
							If MapTemp(x, y + 1) Then
								r\angle = 180 
								TurnEntity(r\obj, 0, r\angle, 0)
							ElseIf MapTemp(x - 1, y)
								r\angle = 270
								TurnEntity(r\obj, 0, r\angle, 0)
							ElseIf MapTemp(x + 1, y)
								r\angle = 90
								TurnEntity(r\obj, 0, r\angle, 0)
							Else 
								r\angle = 0
							End If
						EndIf
					Case 2
						If MapTemp(x - 1, y)>0 And MapTemp(x + 1, y)>0 Then
							If zone% = c_zone%
								r = CreateRoom(zone, ROOM2, x * 8, 0, y * 8, MapName(x, y))
								If Rand(2) = 1 Then r\angle = 90 Else r\angle = 270
								TurnEntity(r\obj, 0, r\angle, 0)
							EndIf
						ElseIf MapTemp(x, y - 1)>0 And MapTemp(x, y + 1)>0
							If zone% = c_zone%
								r = CreateRoom(zone, ROOM2, x * 8, 0, y * 8, MapName(x, y))
								If Rand(2) = 1 Then r\angle = 180 Else r\angle = 0
								TurnEntity(r\obj, 0, r\angle, 0)
							EndIf								
						Else
							If MapTemp(x - 1, y)>0 And MapTemp(x, y + 1)>0 Then
								If zone% = c_zone%
									r = CreateRoom(zone, ROOM2C, x * 8, 0, y * 8, MapName(x, y))
									r\angle = 180
									TurnEntity(r\obj, 0, r\angle, 0)
								EndIf
							ElseIf MapTemp(x + 1, y)>0 And MapTemp(x, y + 1)>0
								If zone% = c_zone%
									r = CreateRoom(zone, ROOM2C, x * 8, 0, y * 8, MapName(x, y))
									r\angle = 90
									TurnEntity(r\obj, 0, r\angle, 0)
								EndIf		
							ElseIf MapTemp(x - 1, y)>0 And MapTemp(x, y - 1)>0
								If zone% = c_zone%
									r = CreateRoom(zone, ROOM2C, x * 8, 0, y * 8, MapName(x, y))
									TurnEntity(r\obj, 0, 270, 0)
									r\angle = 270
								EndIf		
							Else
								If zone% = c_zone%
									r = CreateRoom(zone, ROOM2C, x * 8, 0, y * 8, MapName(x, y))
								EndIf
							EndIf
						EndIf
					Case 3
						If zone% = c_zone%
							r = CreateRoom(zone, ROOM3, x * 8, 0, y * 8, MapName(x, y))
							If (Not MapTemp(x, y - 1)) Then
								TurnEntity(r\obj, 0, 180, 0)
								r\angle = 180
							ElseIf (Not MapTemp(x - 1, y))
								TurnEntity(r\obj, 0, 90, 0)
								r\angle = 90
							ElseIf (Not MapTemp(x + 1, y))
								TurnEntity(r\obj, 0, -90, 0)
								r\angle = 270
							End If
						EndIf
					Case 4
						If zone% = c_zone%
							r = CreateRoom(zone, ROOM4, x * 8, 0, y * 8, MapName(x, y))
						EndIf
				End Select
				
			End If
			
			If MapTemp(x, y)>0 Then
				If (Floor((x + y) / 2.0) = Ceil((x + y) / 2.0)) Then
					If zone = 2 Then temp = 2 Else temp=0
					
					If MapTemp(x + 1, y) Then
						If r <> Null
							d.Doors = CreateDoor(r\zone, Float(x) * spacing + spacing / 2.0, 0, Float(y) * spacing, 90, r, Max(Rand(-3, 1), 0), temp)
							r\AdjDoor[0] = d
						EndIf
					EndIf
					
					If MapTemp(x - 1, y) Then
						If r <> Null
							d.Doors = CreateDoor(r\zone, Float(x) * spacing - spacing / 2.0, 0, Float(y) * spacing, 90, r, Max(Rand(-3, 1), 0), temp)
							r\AdjDoor[2] = d
						EndIf
					EndIf
					
					If MapTemp(x, y + 1) Then
						If r <> Null
							d.Doors = CreateDoor(r\zone, Float(x) * spacing, 0, Float(y) * spacing + spacing / 2.0, 0, r, Max(Rand(-3, 1), 0), temp)
							r\AdjDoor[3] = d
						EndIf
					EndIf
					
					If MapTemp(x, y - 1) Then
						If r <> Null
							d.Doors = CreateDoor(r\zone, Float(x) * spacing, 0, Float(y) * spacing - spacing / 2.0, 0, r, Max(Rand(-3, 1), 0), temp)
							r\AdjDoor[1] = d
						EndIf
					EndIf
				End If
			EndIf
			
		Next
	Next
	
	r = CreateRoom(0, ROOM1, 0, 0, 8, "gatea")
	
	r = CreateRoom(0, ROOM1, (MapWidth-1) * 8, 0, (MapHeight-1) * 8, "pocketdimension")
	
	;r = CreateRoom(0, ROOM1, 8, 0, (MapHeight-1) * 8, "173")
	
	r = CreateRoom(0, ROOM1, 8, 30, (MapHeight-4) * 8, "dimension1499")
	
	For r.Rooms = Each Rooms
		r\Adjacent[0]=Null
		r\Adjacent[1]=Null
		r\Adjacent[2]=Null
		r\Adjacent[3]=Null
		For r2.Rooms = Each Rooms
			If r<>r2 Then
				If r2\z=r\z Then
					If (r2\x)=(r\x+8.0) Then
						r\Adjacent[0]=r2
						If r\AdjDoor[0] = Null Then r\AdjDoor[0] = r2\AdjDoor[2]
					ElseIf (r2\x)=(r\x-8.0)
						r\Adjacent[2]=r2
						If r\AdjDoor[2] = Null Then r\AdjDoor[2] = r2\AdjDoor[0]
					EndIf
				ElseIf r2\x=r\x Then
					If (r2\z)=(r\z-8.0) Then
						r\Adjacent[1]=r2
						If r\AdjDoor[1] = Null Then r\AdjDoor[1] = r2\AdjDoor[3]
					ElseIf (r2\z)=(r\z+8.0)
						r\Adjacent[3]=r2
						If r\AdjDoor[3] = Null Then r\AdjDoor[3] = r2\AdjDoor[1]
					EndIf
				EndIf
			EndIf
			If (r\Adjacent[0]<>Null) And (r\Adjacent[1]<>Null) And (r\Adjacent[2]<>Null) And (r\Adjacent[3]<>Null) Then Exit
		Next
	Next
	
	DrawLoading(40)
	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ = "checkpoint1" Or r\RoomTemplate\Name$ = "checkpoint2"
			FillRoom(r)
			DebugLog "Filled Room"+r\RoomTemplate\Name$
		EndIf
	Next
	
	InitWayPoints()
	
	For d.Doors = Each Doors
		EntityParent(d\obj, 0)
		If d\obj2 > 0 Then EntityParent(d\obj2, 0)
		If d\frameobj > 0 Then EntityParent(d\frameobj, 0)
		If d\buttons[0] > 0 Then EntityParent(d\buttons[0], 0)
		If d\buttons[1] > 0 Then EntityParent(d\buttons[1], 0)
		
		If d\obj2 <> 0 And d\dir = 0 Then
			MoveEntity(d\obj, 0, 0, 8.0 * RoomScale)
			MoveEntity(d\obj2, 0, 0, 8.0 * RoomScale)
		EndIf	
	Next
	
	For it.Items = Each Items
		EntityType (it\obj, HIT_ITEM)
		EntityParent(it\obj, 0)
	Next
	
	For sc.SecurityCams= Each SecurityCams
		sc\angle = EntityYaw(sc\obj) + sc\angle
		EntityParent(sc\obj, 0)
	Next
	
	For r.Rooms = Each Rooms
		For i = 0 To 19
			If r\Lights[i]<>0 Then EntityParent(r\Lights[i],0)
		Next
		
		If (Not r\RoomTemplate\DisableDecals) Then
			If Rand(4) = 1 Then
				de.Decals = CreateDecal(Rand(2, 3), EntityX(r\obj)+Rnd(- 2,2), 0.003, EntityZ(r\obj)+Rnd(-2,2), 90, Rand(360), 0)
				de\Size = Rnd(0.1, 0.4) : ScaleSprite(de\obj, de\Size, de\Size)
				EntityAlpha(de\obj, Rnd(0.85, 0.95))
			EndIf
			
			If Rand(4) = 1 Then
				de.Decals = CreateDecal(0, EntityX(r\obj)+Rnd(- 2,2), 0.003, EntityZ(r\obj)+Rnd(-2,2), 90, Rand(360), 0)
				de\Size = Rnd(0.5, 0.7) : EntityAlpha(de\obj, 0.7) : de\ID = 1 : ScaleSprite(de\obj, de\Size, de\Size)
				EntityAlpha(de\obj, Rnd(0.7, 0.85))
			EndIf
		EndIf
		
	Next
	
	;Local rt.RoomTemplates
	For rt.RoomTemplates = Each RoomTemplates
		FreeEntity (rt\obj)
	Next	
	
	Local tw.TempWayPoints
	For tw.TempWayPoints = Each TempWayPoints
		Delete tw
	Next
	
	DrawLoading(70)
	
	InitEvents()
	
	DebugLog "Created Zone: "+zone%
	
End Function

Function DeInitIntro()
	
	DrawLoading(0)
	
	If NTF_ZoneLoading%
		SZL_CreateZone(3)
	Else
		LoadCompleteMap()
	EndIf
	
	DrawLoading(90)
	
	ClosestButton = 0
	
	For r.Rooms = Each Rooms
		If NTF_CurrZone% = 3
			Select Lower(r\RoomTemplate\Name)
				Case "checkpoint2"
					MTFrooms[0]=r
				Case "room2gs"
					MTFrooms[1]=r	
				Case "room2ccont"
					MTFrooms[2]=r	
				Case "room2poffices"
					MTFrooms[3]=r	
				Case "room2offices"
					MTFrooms[4]=r	
				Case "room2offices2"
					MTFrooms[5]=r	
				Case "room3servers2"
					MTFrooms[6]=r		
			End Select
		ElseIf NTF_CurrZone% = 2
			Select Lower(r\RoomTemplate\Name)
				Case "checkpoint2"
					MTFrooms[0]=r
				Case "checkpoint1"
					MTFrooms[1]=r	
				Case "room106"
					MTFrooms[2]=r	
				Case "room079"
					MTFrooms[3]=r	
				Case "coffin"
					MTFrooms[4]=r	
				Case "room049"
					MTFrooms[5]=r	
				Case "room035"
					MTFrooms[6]=r		
			End Select
		ElseIf NTF_CurrZone% = 1
			Select Lower(r\RoomTemplate\Name)
				Case "checkpoint1"
					MTFrooms[0]=r
				Case "room205"
					MTFrooms[1]=r	
				Case "room1123"
					MTFrooms[2]=r	
				Case "roompj"
					MTFrooms[3]=r	
				Case "room178"
					MTFrooms[4]=r	
				Case "room2scps2"
					MTFrooms[5]=r	
				Case "start"
					MTFrooms[6]=r		
			End Select
		EndIf
	Next
	
	For n.NPCs = Each NPCs
		If n\NPCtype = NPCtypeMTF2
			RemoveNPC(n)
		EndIf
	Next
	
	n.NPCs = CreateNPC(NPCtypeMTF2,0,0,0)
	n\NPCID% = 1
	n.NPCs = CreateNPC(NPCtypeMTF2,0,0,0)
	n\NPCID% = 2
	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ = "gateaentrance"
			PlayerRoom = r
			r\RoomDoors[0]\open = True
			PositionEntity Collider,EntityX(r\Objects[0],True),300*RoomScale,EntityZ(r\Objects[0],True)
			RotateEntity Collider,0,r\angle+90,0
			ResetEntity Collider
			For n.NPCs = Each NPCs
				If n\NPCtype = NPCtypeMTF2
					If n\NPCID% = 1
						PositionEntity n\Collider,EntityX(r\Objects[2],True),300*RoomScale,EntityZ(r\Objects[2],True)
						RotateEntity n\Collider,0,r\angle+90,0
						n\State = 2
					Else
						PositionEntity n\Collider,EntityX(r\Objects[3],True),300*RoomScale,EntityZ(r\Objects[3],True)
						RotateEntity n\Collider,0,r\angle+90,0
						n\State = 3
						n\Target = Before n
					EndIf
					ResetEntity n\Collider
				EndIf
			Next
			Exit
		EndIf
	Next
	
	Brightness = 40
	
	For i% = 0 To 70
		FPSfactor = 1.0
		FlushKeys()
		MovePlayer()
		UpdateDoors()
		UpdateNPCs()
		UpdateWorld()
		;Cls
		DrawLoading(80+Int(Float(i)*0.27))
	Next
	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ <> "gateaentrance"
			DebugLog "FORCED 173 TELEPORTATION TO: "+r\roomtemplate\name
			PositionEntity Curr173\Collider, EntityX(r\obj,True), EntityY(r\obj,True)+0.5,EntityZ(r\obj,True)
			ResetEntity Curr173\Collider
			Exit
		EndIf
	Next
	
	DropSpeed = 0
	
	If PlayerRoom = Null Then RuntimeError "GateAEntrance Room not found"
	
	DrawLoading(100)
	
End Function

Global SplashText_Timer# = 0.0
Global SplashText_Timer2# = 0.0
Global SplashText_Timer3# = 255.0
Global SplashText_ShowTime# = 0.0
Global SplashText_CurrentLength% = 0
Global SplashText_Length% = 0
Global SplashText_X# = 0.0
Global SplashText_Y# = 0.0
Global SplashText_Text$ = ""

Function SetSplashText(txt$,x#,y#,show_time#)
	
	SplashText_Timer# = 0.0
	SplashText_timer2# = 0.0
	SplashText_Timer3# = 255.0
	SplashText_Text$ = txt$
	SplashText_X# = x#
	SplashText_Y# = y#
	SplashText_ShowTime# = show_time#
	SplashText_Length% = Len(SplashText_Text$)
	SplashText_CurrentLength% = 0
	
End Function

Function DrawSplashText()
	
	If SplashText_Text$ <> ""
		If SplashText_Timer2# = 0.0
			If SplashText_Timer# < 10.0
				SplashText_Timer# = SplashText_Timer# + FPSFactor#
			Else
				SplashText_CurrentLength = SplashText_CurrentLength + 1
				SplashText_Timer# = 0.0
			EndIf
		EndIf
		
		If SplashText_CurrentLength = SplashText_Length%
			If SplashText_Timer2# < SplashText_ShowTime#
				SplashText_Timer2# = SplashText_Timer2# + FPSFactor
			Else
				If SplashText_Timer3# > 0.0
					SplashText_Timer3# = SplashText_Timer3# - FPSFactor
				Else
					SplashText_Text$ = ""
				EndIf
			EndIf
		EndIf
		
		If SplashText_Timer3# > 0.0
			Color SplashText_Timer3#,SplashText_Timer3#,SplashText_Timer3#
			Text SplashText_X#,SplashText_Y#,Left(SplashText_Text$,SplashText_CurrentLength%)
		EndIf
	EndIf
	
End Function

Type CoordPoints
	Field name$
	Field obj%
End Type

Function CreateCoordPoint.CoordPoints(name$,x#,y#,z#,parent%=0,pos%=False)
	Local cdp.CoordPoints = New CoordPoints
	
	cdp\name$ = name$
	cdp\obj% = CreatePivot(parent%)
	PositionEntity cdp\obj%,x#,y#,z#,pos%
	
	Return cdp
End Function

Function DeleteCoordPoint(cdp.CoordPoints)
	
	If cdp\obj% <> 0 Then FreeEntity cdp\obj% : cdp\obj% = 0
	Delete cdp
	
End Function

Function Between(a#,value#,b#)
	
	If a# > value#
		Return a#
	ElseIf b# < value#
		Return b#
	Else
		Return value#
	EndIf
	
End Function

Function LoadCompleteMap()
	Local r.Rooms
	
	For wp.WayPoints = Each WayPoints
		If wp\room\RoomTemplate\Name$ <> "checkpoint1" And wp\room\RoomTemplate\Name$ <> "checkpoint2"
			RemoveWaypoint(wp)
		EndIf
	Next
	For twp.TempWayPoints = Each TempWayPoints
		Delete twp
	Next	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ <> "checkpoint1" And r\RoomTemplate\Name$ <> "checkpoint2"
			For i = 0 To 19
				If r\Lights[i]<> 0 Then FreeEntity r\Lights[i] : r\Lights[i]=0
			Next
			FreeEntity r\obj% : r\obj%=0
			Delete r
		EndIf
	Next
	For e.Events = Each Events
		If e\eventName <> "checkpoint"
			RemoveEvent(e)
		EndIf
	Next
	For d.Doors = Each Doors
		RemoveDoor(d)
	Next
	For n.NPCs = Each NPCs
		If n\NPCtype <> NPCtypeMTF2
			If n <> Curr173 And n <> Curr106 And n <> Curr096
				RemoveNPC(n)
			EndIf
		EndIf
	Next
	Local it.Items
	For it.Items = Each Items
		If it\Picked = False
			RemoveItem(it)
		EndIf
	Next
	For pr.Props = Each Props
		Delete pr
	Next
	For scr.Screens = Each Screens
		Delete scr
	Next
	For sc.securitycams = Each SecurityCams
		Delete sc
	Next
	For em.emitters = Each Emitters
		Delete em
	Next
	For rt.RoomTemplates = Each RoomTemplates
		rt\obj = 0
	Next
	
	DrawLoading(10)
	
	;Dim MapRoomID%(ROOM4 + 1)
	
	temp = 0
	;Local r.Rooms
	Local spacing# = 8.0
	For y = MapHeight - 1 To 1 Step - 1
		
		;zone% = GetZone(y)
		
		If y < MapHeight/3+1 Then
			zone=3
		ElseIf y < MapHeight*(2.0/3.0);-1
			zone=2
		Else
			zone=1
		EndIf
		
		For x = 1 To MapWidth - 2
			;If MapTemp(x, y) = 255 Then
			
			;ElseIf MapTemp(x, y) > 0
			If MapTemp(x, y) > 0 And MapTemp(x, y) <> 255
				
				temp = Min(MapTemp(x + 1, y),1) + Min(MapTemp(x - 1, y),1) + Min(MapTemp(x, y + 1),1) + Min(MapTemp(x, y - 1),1)
				
				Select temp
					Case 1
						r = CreateRoom(zone, ROOM1, x * 8, 0, y * 8, MapName(x, y))
						If MapTemp(x, y + 1) Then
							r\angle = 180 
							TurnEntity(r\obj, 0, r\angle, 0)
						ElseIf MapTemp(x - 1, y)
							r\angle = 270
							TurnEntity(r\obj, 0, r\angle, 0)
						ElseIf MapTemp(x + 1, y)
							r\angle = 90
							TurnEntity(r\obj, 0, r\angle, 0)
						Else 
							r\angle = 0
						End If
					Case 2
						If MapTemp(x - 1, y)>0 And MapTemp(x + 1, y)>0 Then
							r = CreateRoom(zone, ROOM2, x * 8, 0, y * 8, MapName(x, y))
							If Rand(2) = 1 Then r\angle = 90 Else r\angle = 270
							TurnEntity(r\obj, 0, r\angle, 0)
						ElseIf MapTemp(x, y - 1)>0 And MapTemp(x, y + 1)>0
							r = CreateRoom(zone, ROOM2, x * 8, 0, y * 8, MapName(x, y))
							If Rand(2) = 1 Then r\angle = 180 Else r\angle = 0
							TurnEntity(r\obj, 0, r\angle, 0)								
						Else
							If MapTemp(x - 1, y)>0 And MapTemp(x, y + 1)>0 Then
								r = CreateRoom(zone, ROOM2C, x * 8, 0, y * 8, MapName(x, y))
								r\angle = 180
								TurnEntity(r\obj, 0, r\angle, 0)
							ElseIf MapTemp(x + 1, y)>0 And MapTemp(x, y + 1)>0
								r = CreateRoom(zone, ROOM2C, x * 8, 0, y * 8, MapName(x, y))
								r\angle = 90
								TurnEntity(r\obj, 0, r\angle, 0)		
							ElseIf MapTemp(x - 1, y)>0 And MapTemp(x, y - 1)>0
								r = CreateRoom(zone, ROOM2C, x * 8, 0, y * 8, MapName(x, y))
								TurnEntity(r\obj, 0, 270, 0)
								r\angle = 270		
							Else
								r = CreateRoom(zone, ROOM2C, x * 8, 0, y * 8, MapName(x, y))
							EndIf
						EndIf
					Case 3
						r = CreateRoom(zone, ROOM3, x * 8, 0, y * 8, MapName(x, y))
						If (Not MapTemp(x, y - 1)) Then
							TurnEntity(r\obj, 0, 180, 0)
							r\angle = 180
						ElseIf (Not MapTemp(x - 1, y))
							TurnEntity(r\obj, 0, 90, 0)
							r\angle = 90
						ElseIf (Not MapTemp(x + 1, y))
							TurnEntity(r\obj, 0, -90, 0)
							r\angle = 270
						End If
					Case 4
						r = CreateRoom(zone, ROOM4, x * 8, 0, y * 8, MapName(x, y))
				End Select
				
			End If
			
			If MapTemp(x, y)>0 Then
				If (Floor((x + y) / 2.0) = Ceil((x + y) / 2.0)) Then
					If zone = 2 Then temp = 2 Else temp=0
					
					If MapTemp(x + 1, y) Then
						If r <> Null
							d.Doors = CreateDoor(r\zone, Float(x) * spacing + spacing / 2.0, 0, Float(y) * spacing, 90, r, Max(Rand(-3, 1), 0), temp)
							r\AdjDoor[0] = d
						EndIf
					EndIf
					
					If MapTemp(x - 1, y) Then
						If r <> Null
							d.Doors = CreateDoor(r\zone, Float(x) * spacing - spacing / 2.0, 0, Float(y) * spacing, 90, r, Max(Rand(-3, 1), 0), temp)
							r\AdjDoor[2] = d
						EndIf
					EndIf
					
					If MapTemp(x, y + 1) Then
						If r <> Null
							d.Doors = CreateDoor(r\zone, Float(x) * spacing, 0, Float(y) * spacing + spacing / 2.0, 0, r, Max(Rand(-3, 1), 0), temp)
							r\AdjDoor[3] = d
						EndIf
					EndIf
					
					If MapTemp(x, y - 1) Then
						If r <> Null
							d.Doors = CreateDoor(r\zone, Float(x) * spacing, 0, Float(y) * spacing - spacing / 2.0, 0, r, Max(Rand(-3, 1), 0), temp)
							r\AdjDoor[1] = d
						EndIf
					EndIf
				End If
			EndIf
			
		Next
	Next
	
	r = CreateRoom(0, ROOM1, 0, 0, 8, "gatea")
	
	r = CreateRoom(0, ROOM1, (MapWidth-1) * 8, 0, (MapHeight-1) * 8, "pocketdimension")
	
	;r = CreateRoom(0, ROOM1, 8, 0, (MapHeight-1) * 8, "173")
	
	r = CreateRoom(0, ROOM1, 8, 30, (MapHeight-4) * 8, "dimension1499")
	
	For r.Rooms = Each Rooms
		r\Adjacent[0]=Null
		r\Adjacent[1]=Null
		r\Adjacent[2]=Null
		r\Adjacent[3]=Null
		For r2.Rooms = Each Rooms
			If r<>r2 Then
				If r2\z=r\z Then
					If (r2\x)=(r\x+8.0) Then
						r\Adjacent[0]=r2
						If r\AdjDoor[0] = Null Then r\AdjDoor[0] = r2\AdjDoor[2]
					ElseIf (r2\x)=(r\x-8.0)
						r\Adjacent[2]=r2
						If r\AdjDoor[2] = Null Then r\AdjDoor[2] = r2\AdjDoor[0]
					EndIf
				ElseIf r2\x=r\x Then
					If (r2\z)=(r\z-8.0) Then
						r\Adjacent[1]=r2
						If r\AdjDoor[1] = Null Then r\AdjDoor[1] = r2\AdjDoor[3]
					ElseIf (r2\z)=(r\z+8.0)
						r\Adjacent[3]=r2
						If r\AdjDoor[3] = Null Then r\AdjDoor[3] = r2\AdjDoor[1]
					EndIf
				EndIf
			EndIf
			If (r\Adjacent[0]<>Null) And (r\Adjacent[1]<>Null) And (r\Adjacent[2]<>Null) And (r\Adjacent[3]<>Null) Then Exit
		Next
	Next
	
	DrawLoading(40)
	
	For r.Rooms = Each Rooms
		If r\RoomTemplate\Name$ = "checkpoint1" Or r\RoomTemplate\Name$ = "checkpoint2"
			FillRoom(r)
			DebugLog "Filled Room"+r\RoomTemplate\Name$
		EndIf
	Next
	
	InitWayPoints()
	
	For d.Doors = Each Doors
		EntityParent(d\obj, 0)
		If d\obj2 > 0 Then EntityParent(d\obj2, 0)
		If d\frameobj > 0 Then EntityParent(d\frameobj, 0)
		If d\buttons[0] > 0 Then EntityParent(d\buttons[0], 0)
		If d\buttons[1] > 0 Then EntityParent(d\buttons[1], 0)
		
		If d\obj2 <> 0 And d\dir = 0 Then
			MoveEntity(d\obj, 0, 0, 8.0 * RoomScale)
			MoveEntity(d\obj2, 0, 0, 8.0 * RoomScale)
		EndIf	
	Next
	
	For it.Items = Each Items
		EntityType (it\obj, HIT_ITEM)
		EntityParent(it\obj, 0)
	Next
	
	For sc.SecurityCams= Each SecurityCams
		sc\angle = EntityYaw(sc\obj) + sc\angle
		EntityParent(sc\obj, 0)
	Next
	
	For r.Rooms = Each Rooms
		For i = 0 To 19
			If r\Lights[i]<>0 Then EntityParent(r\Lights[i],0)
		Next
		
		If (Not r\RoomTemplate\DisableDecals) Then
			If Rand(4) = 1 Then
				de.Decals = CreateDecal(Rand(2, 3), EntityX(r\obj)+Rnd(- 2,2), 0.003, EntityZ(r\obj)+Rnd(-2,2), 90, Rand(360), 0)
				de\Size = Rnd(0.1, 0.4) : ScaleSprite(de\obj, de\Size, de\Size)
				EntityAlpha(de\obj, Rnd(0.85, 0.95))
			EndIf
			
			If Rand(4) = 1 Then
				de.Decals = CreateDecal(0, EntityX(r\obj)+Rnd(- 2,2), 0.003, EntityZ(r\obj)+Rnd(-2,2), 90, Rand(360), 0)
				de\Size = Rnd(0.5, 0.7) : EntityAlpha(de\obj, 0.7) : de\ID = 1 : ScaleSprite(de\obj, de\Size, de\Size)
				EntityAlpha(de\obj, Rnd(0.7, 0.85))
			EndIf
		EndIf
		
	Next
	
	;Local rt.RoomTemplates
	For rt.RoomTemplates = Each RoomTemplates
		FreeEntity (rt\obj)
	Next	
	
	Local tw.TempWayPoints
	For tw.TempWayPoints = Each TempWayPoints
		Delete tw
	Next
	
	DrawLoading(70)
	
	InitEvents()
	
	DebugLog "Loaded Complete Map successfully"
	
End Function

Function PlayIntroSFX(CHN%)
	
	If Intro_SFX_Timer# > 0.0
		Intro_SFX_Timer# = Intro_SFX_Timer# - FPSFactor
	ElseIf Intro_SFX_Timer# < 0.01 And Intro_SFX_Timer# > -10.0
		Intro_CurrSound% = Intro_CurrSound% + 1
		Intro_SFX_Timer# = 0.0
	EndIf
	
	If Intro_SFX_Timer# = 0.0
		If ChannelPlaying(CHN%) Then StopChannel(CHN%)
		If Intro_SFX <> 0 Then FreeSound Intro_SFX : Intro_SFX = 0
		Intro_SFX = LoadSound_Strict("NineTailedFoxMod\SFX\Intro\heli_line"+Intro_CurrSound%+".ogg")
		CHN% = PlaySound(Intro_SFX)
		Intro_SFX_Timer# = -10.0
	EndIf
	
End Function
;~IDEal Editor Parameters:
;~C#Blitz3D