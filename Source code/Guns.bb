Global GunPivot,GunParticle
Global HoldingGun = 0

Global ShootEmptySFX

Global MuzzleFlash

Global KEY_RELOAD = 19

Global GunPickPivot

Global GunPivot_Y#
Global GunPivot_YSide% = 0
Global GunPivot_X#
Global GunPivot_XSide% = 0

Global GunAnimFLAG = False

Global GunChangeFLAG = False

Global GunUpdateFLAG = 0

; ------ guns
Const GUN_USP = 1
Const GUN_P90 = 2
Const GUN_AK = 3
Const GUN_MP5 = 4
Const GUN_M249 = 5
Const GUN_PG = 6
; ------ anims
Const IDLE_ANIM = 1
Const RELOAD_ANIM = 2
Const SHOOT_ANIM = 3
Const DEPLOY_ANIM = 4
Const DEPLOY_FRAME = 5

Type Guns
	Field ID					;<--- The ID of the gun. WARNING: Overwriting existing IDs could cause to the game would be glitched or at the worst case a MAV
	Field CurrAmmo				;<--- Current ammo in a magazine
	Field MaxCurrAmmo			;<--- Max ammo in a magazine
	Field ShootState# = 0.0		;<--- Dont change this variables in the "CreateGun" or "InitGuns" functions!
	Field ShootSpeed# 			;<--- speed shoot
	Field ReloadState# = 0.0	;<--- 								"-"
	Field DeployState# = 0.0	;<---								"-"
	Field GunState = 0			;<---								"-"
	Field Deployed% = 0			;<---								"-"
	Field Holster% = 0			;<---								"-"
	Field ShootAnim = 0			;<---								"-"
	Field PrevFrame#
	Field Magazines
	Field ShootSound
	Field DeploySound
	Field ReloadSound
	Field ViewModel%
	Field ChannelGun
	Field ReloadAnim#[2]
	Field IdleAnim#
	Field DeployFrame#
	Field DeployAnim#[2]
	Field ShootFrame#[2]
	Field SingleMode
	Field SightRate#, SightState%, CurrentSightMove#
End Type
Global EqquipedGun.Guns

Function CreateGun.Guns(id, single, viewmodel$, shootsound$, reloadsound$, deploysound$, speed#, ammo, maxammo, magazines, scalex#, scaley#, scalez#, movex#=0, movey#=0, movez#=0)
	Local g.Guns = New Guns
	
	g\ID = id
	g\CurrAmmo = ammo
	g\MaxCurrAmmo = maxammo
	g\Magazines = magazines
	g\ShootSpeed# = speed#
	g\ViewModel = LoadAnimMesh_Strict(viewmodel)
	
	ScaleEntity g\ViewModel,scalex#,scaley#,scalez#
	EntityParent g\ViewModel,GunPivot
	MoveEntity g\ViewModel,movex,movey,movez
	HideEntity g\ViewModel
	
	g\ShootSound = LoadSound_Strict(shootsound)
	g\ReloadSound = LoadSound_Strict(reloadsound)
	g\DeploySound = LoadSound_Strict(deploysound)
	g\SingleMode = single
	
	MeshCullBox (g\ViewModel, -MeshWidth(g\ViewModel), -MeshHeight(g\ViewModel), -MeshDepth(g\ViewModel), MeshWidth(g\ViewModel)*2, MeshHeight(g\ViewModel)*2, MeshDepth(g\ViewModel)*2)
	
	Return g
End Function

Function InitGuns()
	
	GunAnimFLAG = False
	
	GunChangeFLAG = False
	
	GunUpdateFLAG = 0
	
	HoldingGun = 0
	
	ShootEmptySFX = LoadSound_Strict("SFX\shoot_empty.ogg")
	
	GunPivot = CreatePivot()
	
	GunPickPivot = CreatePivot()
	EntityParent GunPickPivot,GunPivot
	
	MuzzleFlash = LoadTexture("GFX\flash.jpg",1+2)
	
	GunParticle = CreateSprite()
	EntityParent GunParticle,GunPivot
	MoveEntity GunParticle,0.06,-0.03,0.45
	EntityTexture(GunParticle, MuzzleFlash)
	EntityFX(GunParticle, 1 + 8)
	SpriteViewMode (GunParticle, 3)
	EntityBlend(GunParticle, BLEND_ADD)
	ScaleSprite(GunParticle, 0.09, 0.09)
	HideEntity GunParticle
	
	CreateGun(GUN_USP,True, "GFX\items\USP_Tactical_Viewmodel.b3d", "SFX\Guns\USP\shoot.ogg", "SFX\Guns\USP\reload.ogg", "SFX\Guns\USP\deploy.ogg", 2.5, 12, 12, 200, 0.016, 0.016, 0.016,0.01,0.0,0.02)
	;CreateGun(GUN_M9,True, "GFX\items\M9_Beretta_Viewmodel.b3d", "SFX\Guns\M9\shoot.ogg", "SFX\Guns\M9\reload.ogg", "SFX\Guns\M9\deploy.ogg", 2.5, 12, 12, 200, 0.016, 0.016, 0.016,0.01,0.0,0.02)
	CreateGun(GUN_P90,False, "GFX\items\P90_Viewmodel.b3d", "SFX\Guns\P90\shoot.ogg", "SFX\Guns\P90\reload.ogg", "SFX\Guns\P90\deploy.ogg", 5, 50, 50, 200, 0.012, 0.012, 0.012, 0.01, 0.015, 0.0)
	CreateGun(GUN_AK,False, "GFX\Custom Gun Textures for frens\ak_v.b3d", "SFX\Guns\AK\shoot.ogg", "SFX\Guns\AK\reload.ogg", "SFX\Guns\AK\deploy.ogg", 5, 50, 50, 200, 0.012, 0.012, 0.012, 0.01)
	CreateGun(GUN_M249,False, "GFX\Guns\m249\m249_viewmodel.b3d", "SFX\Guns\m249\shoot.ogg", "SFX\Guns\m249\reload.ogg", "SFX\Guns\m249\deploy.ogg", 5, 100, 100, 200, 0.012, 0.012, 0.012, 0.01)
	CreateGun(GUN_PG,False, "GFX\Guns\pg\pimp gun4.b3d", "SFX\Guns\USP\shoot.ogg", "SFX\Guns\USP\reload.ogg", "SFX\Guns\m249\deploy.ogg", 0.5, 12, 12, 200, 0.016, 0.016, 0.016,0.01,0.0,2.06)
	;CreateGun(GUN_MP5,False, "GFX\items\mp5_Viewmodel.b3d", "SFX\Guns\mp5\shoot.ogg", "SFX\Guns\mp5\reload.ogg", "SFX\Guns\mp5\deploy.ogg", 5, 50, 50, 200, 0.012, 0.012, 0.012, 0.01)
	For g.Guns = Each Guns
		Select g\ID
			Case GUN_USP: 
				AddFrameToGun(g, IDLE_ANIM, 41)
				AddFrameToGun(g, DEPLOY_ANIM, 1, 37)
				AddFrameToGun(g, DEPLOY_FRAME, 12)
				AddFrameToGun(g, RELOAD_ANIM, 105, 168)
				AddFrameToGun(g, SHOOT_ANIM,171,197)
				AddSightRateToGun(g, -0.050)
			Case GUN_P90: 
				AddFrameToGun(g, IDLE_ANIM, 32)
				AddFrameToGun(g, DEPLOY_ANIM, 1, 30)
				AddFrameToGun(g, DEPLOY_FRAME, 2)
				AddFrameToGun(g, RELOAD_ANIM, 50, 199)
				AddFrameToGun(g, SHOOT_ANIM,200,228)
				AddSightRateToGun(g, -0.040)
			Case GUN_AK: 
				AddFrameToGun(g, IDLE_ANIM, 28)
				AddFrameToGun(g, DEPLOY_ANIM, 1, 26)
				AddFrameToGun(g, DEPLOY_FRAME, 1)
				AddFrameToGun(g, RELOAD_ANIM, 29, 101)	
				AddFrameToGun(g, SHOOT_ANIM,102,119)
				AddSightRateToGun(g, -0.105)
			Case GUN_MP5: 
				AddFrameToGun(g, IDLE_ANIM, 12)
				AddFrameToGun(g, DEPLOY_ANIM, 1, 12)
				AddFrameToGun(g, DEPLOY_FRAME, 13)
				AddFrameToGun(g, RELOAD_ANIM, 32, 133)
				AddFrameToGun(g, SHOOT_ANIM,133,145)
				AddSightRateToGun(g, -0.048)
			Case GUN_M249: 
				AddFrameToGun(g, IDLE_ANIM, 43)
				AddFrameToGun(g, DEPLOY_ANIM, 1, 41)
				AddFrameToGun(g, DEPLOY_FRAME, 1)
				AddFrameToGun(g, RELOAD_ANIM, 44, 237)
				AddFrameToGun(g, SHOOT_ANIM,238,257)
				AddSightRateToGun(g, -0.048)
			Case GUN_PG: 
				AddFrameToGun(g, IDLE_ANIM, 205)
				AddFrameToGun(g, DEPLOY_ANIM, 105, 205)
				AddFrameToGun(g, DEPLOY_FRAME, 1)
				AddFrameToGun(g, RELOAD_ANIM, 205, 243)
				AddFrameToGun(g, SHOOT_ANIM,67,92)
		End Select
	Next
End Function
Function AddFrameToGun(g.Guns, aType, start, endanim = 0)
	Select aType
		Case IDLE_ANIM
			g\IdleAnim = start
		Case RELOAD_ANIM
			g\ReloadAnim[0] = start
			g\ReloadAnim[1] = endanim
		Case SHOOT_ANIM
			g\ShootFrame[0] = start
			g\ShootFrame[1] = endanim
		Case DEPLOY_ANIM
			g\DeployAnim[0] = start
			g\DeployAnim[1] = endanim
		Case DEPLOY_FRAME
			g\DeployFrame = start
	End Select
End Function
Function GetIdleAnim#(g.Guns)
	Return g\IdleAnim
End Function
Function AddSightRateToGun(g.Guns, aType#)
	g\SightRate = aType
End Function
Function GetReloadAnim#(g.Guns, startend)
	Return g\ReloadAnim[startend]
End Function
Function GetShootAnim#(g.Guns, startend)
	Return g\ShootFrame[startend]
End Function
Function GetDeployFrame#(g.Guns)
	Return g\DeployFrame
End Function
Function GetDeployAnim#(g.Guns, startend)
	Return g\DeployAnim[startend]
End Function
Function DeleteGuns()
	
	For g.Guns = Each Guns
		Delete g
	Next
	
	FreeSound_Strict ShootEmptySFX : ShootEmptySFX = 0
	
End Function

Function UpdateGuns()
	Local g.Guns, n.NPCs
	Local de.Decals
	AnimateGuns()
	GunAnimFLAG = True
	HoldingGun = 0
	For g.Guns = Each Guns
		g\PrevFrame = AnimTime(g\ViewModel)
		If EqquipedGun = g Then
			RotateEntity GunPivot,EntityPitch(Camera), EntityYaw(Camera), 0
			ShowEntity g\ViewModel
			HoldingGun = g\ID
			If g\ReloadState# = 0.0 And g\ShootState# = 0.0
				If g\Deployed = 1 Then
					If g\CurrAmmo < g\MaxCurrAmmo And g\Magazines > 0 Then
						If AnimTime(g\ViewModel) = GetIdleAnim(g) Then
							If KeyHit(KEY_RELOAD)
								g\CurrAmmo = 0
								PlayGunSound(g\ReloadSound)
								g\PrevFrame# = GetReloadAnim(g, 0)
								Animate2(g\ViewModel,AnimTime(g\ViewModel),GetReloadAnim(g, 0),GetReloadAnim(g, 0),0.5,False)
								g\ReloadState# = 1.0
							EndIf
						Else
							If KeyHit(KEY_RELOAD) Then FlushKeys()
						EndIf
					Else
						If KeyHit(KEY_RELOAD) Then FlushKeys()
					EndIf
				Else
					If KeyHit(KEY_RELOAD) Then FlushKeys()
				EndIf
			ElseIf g\ReloadState# > 0.0 And g\ShootState# = 0.0
				Animate2(g\ViewModel,AnimTime(g\ViewModel),GetReloadAnim(g, 0),GetReloadAnim(g, 1),0.5,False)
				If g\PrevFrame# < GetReloadAnim(g, 1)-1 And AnimTime(g\ViewModel)=> GetReloadAnim(g, 1)-1
					g\CurrAmmo = g\MaxCurrAmmo
					g\Magazines = g\Magazines - 1
					g\ReloadState# = 0.0
					Animate2(g\ViewModel,AnimTime(g\ViewModel),GetIdleAnim(g),GetIdleAnim(g),1,False)
					g\PrevFrame# = GetIdleAnim(g)
				EndIf
			EndIf
			
			If g\ReloadState# = 0.0
				If g\Deployed = 0
					Animate2(g\ViewModel,AnimTime(g\ViewModel),GetDeployAnim(g, 0),GetDeployAnim(g, 1),0.5,False)
					If g\PrevFrame# < GetDeployFrame(g) And AnimTime(g\ViewModel)=>GetDeployFrame(g)
						PlayGunSound(g\DeploySound)
					ElseIf g\PrevFrame# < GetDeployAnim(g, 1)-0.5 And AnimTime(g\ViewModel)=>GetDeployAnim(g, 1)-0.5	
						Animate2(g\ViewModel,AnimTime(g\ViewModel),GetIdleAnim(g),GetIdleAnim(g),1,False)
						g\PrevFrame# = GetIdleAnim(g)
						g\Deployed = 1
					EndIf
				Else
					If g\ShootAnim = 1
						Animate2(g\ViewModel,AnimTime(g\ViewModel),GetShootAnim(g, 0),GetShootAnim(g, 1),0.5,False)
						If g\PrevFrame# < GetShootAnim(g, 1)-1 And AnimTime(g\ViewModel) => GetShootAnim(g, 1)-1
							Animate2(g\ViewModel,AnimTime(g\ViewModel),GetIdleAnim(g),GetIdleAnim(g),1,False)
							g\PrevFrame# = GetIdleAnim(g)
							g\ShootAnim = 0
						EndIf
					EndIf
					
					If g\ShootState# = 0.0 Then
						If g\SingleMode = True Or g\CurrAmmo < 1 Then
							If MouseHit1
								If ClosestButton=0 And ClosestItem=Null And GrabbedEntity%=0 And ClosestItem = Null And ClosestButton = 0 And MenuOpen = False And InvOpen = False And ChatOpen = False Then
									g\ShootAnim = 0
									Animate2(g\ViewModel,AnimTime(g\ViewModel),GetShootAnim(g, 0),GetShootAnim(g, 0),0.5,False)
									g\PrevFrame# = GetShootAnim(g, 0)
									g\ShootState# = 1.0
								Else
									GunAnimFLAG = False
								EndIf
							EndIf
						Else
							If MouseDown1 Then
								If ClosestButton=0 And ClosestItem=Null And GrabbedEntity%=0 And ClosestItem = Null And ClosestButton = 0 And MenuOpen = False And InvOpen = False And ChatOpen = False Then
									g\ShootAnim = 0
									Animate2(g\ViewModel,AnimTime(g\ViewModel),GetShootAnim(g, 0),GetShootAnim(g, 0),0.5,False)
									g\PrevFrame# = GetShootAnim(g, 0)
									g\ShootState# = 1.0
								Else
									GunAnimFLAG = False
								EndIf
							EndIf
						EndIf
					ElseIf g\ShootState# = 1.0
						If g\CurrAmmo > 0 Then
							PlayGunSound(g\ShootSound)
							USER_CAMERA_PITCH = USER_CAMERA_PITCH -1
							ShowEntity GunParticle
							RotateEntity GunParticle,0,0,Rnd(360)
							
							EntityPickMode Collider,0
							pvt = CreatePivot()
							PositionEntity pvt, EntityX(Collider),((EntityY(Collider)+EntityY(Camera))/2)+0.3,EntityZ(Collider)
							TurnEntity pvt, EntityPitch(camera), EntityYaw(camera), 0
							If Crouch Then PositionEntity pvt, EntityX(Collider),((EntityY(Collider)+EntityY(Camera))/2)+0.2,EntityZ(Collider)
							EntityPick(pvt, 1000)
							
							FreeEntity pvt
							Local pickedent = PickedEntity()
							;shoot
							For n.NPCs = Each NPCs
								If n\NPCtype = NPCtypeMTF
									If PickedEntity() = n\HitBox
										DebugLog "D found"
										n\HP% = n\HP% - 20
										temp = 2
										Exit
									ElseIf PickedEntity() = n\HitBoxHead
										DebugLog "D found + Head"
										n\HP% = n\HP% - 60
										temp = 2
										Exit
									EndIf
								EndIf
								If n\NPCtype = NPCtype173
									If PickedEntity() = n\HitBox
										DebugLog "D found"
										n\HP% = n\HP% - 20
										temp = 2
										Exit
									ElseIf PickedEntity() = n\HitBoxHead
										DebugLog "D found + Head"
										n\HP% = n\HP% - 35
										temp = 2
										Exit
									EndIf
								EndIf
								If n\NPCtype = NPCtypeZombie
									If PickedEntity() = n\obj
										DebugLog "D found"
										n\HP% = n\HP% - 20
										temp = 2
										Exit
									EndIf
								EndIf
								If n\NPCtype = NPCtype966
									If PickedEntity() = n\HitBox
										DebugLog "D found"
										n\HP% = n\HP% - 20
										temp = 2
										Exit
									ElseIf PickedEntity() = n\HitBoxHead
										DebugLog "D found + Head"
										n\HP% = n\HP% - 35
										temp = 2
										Exit
									EndIf
								EndIf
								If n\NPCtype = NPCtype008
									If PickedEntity() = n\HitBox
										DebugLog "D found"
										n\HP% = n\HP% - 20
										temp = 2
										Exit
									ElseIf PickedEntity() = n\HitBoxHead
										DebugLog "D found + Head"
										n\HP% = n\HP% - 60
										temp = 2
										Exit
									EndIf
								EndIf
								If n\NPCtype = NPCtype066
									If PickedEntity() = n\HitBox
										DebugLog "D found"
										n\HP% = n\HP% - 20
										temp = 2
										Exit
									EndIf
								EndIf
								If n\NPCtype = NPCtypeApache
									If PickedEntity() = n\HitBox
										DebugLog "D found"
										n\HP% = n\HP% - 20
										temp = 2
										Exit
									EndIf
								EndIf
								If n\NPCtype = NPCtypeOldMan
									If PickedEntity() = n\HitBox
										DebugLog "D found"
										n\HP% = n\HP% - 20
										temp = 2
										Exit
									ElseIf PickedEntity() = n\HitBoxHead
										DebugLog "D found + Head"
										n\HP% = n\HP% - 60
										temp = 2
										Exit
									EndIf
								EndIf
								If n\NPCtype = NPCtype049
									If PickedEntity() = n\HitBox
										DebugLog "D found"
										n\HP% = n\HP% - 20
										temp = 2
										Exit
									ElseIf PickedEntity() = n\HitBoxHead
										DebugLog "D found + Head"
										n\HP% = n\HP% - 60
										temp = 2
										Exit
									EndIf
								EndIf
							Next
							If temp = 1 Or temp = 2 Then
								If (Not n\NPCType = NPCType173) And (Not n\NPCType = NPCTypeOldMan) Then
									p.Particles = CreateParticle(PickedX(),PickedY(),PickedZ(), 5, 0.06, 0.2, 80)
								ElseIf n\NPCType = NPCType173 Then
									p.Particles = CreateParticle(PickedX(),PickedY(),PickedZ(), 0, 0.06, 0.2, 80)
								ElseIf n\NPCType = NPCTypeOldMan Then
									p.Particles = CreateParticle(PickedX(),PickedY(),PickedZ(), 9, 0.06, 0.2, 80)
								EndIf
								p\speed = 0.001
								p\SizeChange = 0.003
								p\A = 0.8
								p\Achange = -0.02
							Else
								p.Particles = CreateParticle(PickedX(),PickedY(),PickedZ(), 0, 0.03, 0, 80)
								p\speed = 0.001
								p\SizeChange = 0.003
								p\A = 0.8
								p\Achange = -0.01
								RotateEntity p\pvt, EntityPitch(Camera)+-180, EntityYaw(Camera),0
								For i = 0 To Rand(2,3)
									p.Particles = CreateParticle(PickedX(),PickedY(),PickedZ(), 0, 0.006, 0.003, 80)
									p\speed = 0.02
									p\A = 0.8
									p\Achange = -0.01
									RotateEntity p\pvt, EntityPitch(Camera)+Rand(170,190), EntityYaw(Camera)+Rand(0,10),0    
								Next
								
								;bullet hole decal
								de.Decals = CreateDecal(Rand(13,14), PickedX(),PickedY(),PickedZ(), 0,0,0)
								AlignToVector de\obj,-PickedNX(),-PickedNY(),-PickedNZ(),3
								MoveEntity de\obj, 0,0,-0.001
								EntityFX de\obj, 1
								de\lifetime = 70*20
								EntityBlend de\obj, 2
								de\Size = Rnd(0.028,0.034)
								ScaleSprite de\obj, de\Size, de\Size
							EndIf
						Else
							PlaySound_Strict ShootEmptySFX
						EndIf
						g\ShootState# = g\ShootState# + FPSfactor#
						
					ElseIf g\ShootState# > 1.0 And g\ShootState# < g\ShootSpeed
						g\ShootState# = g\ShootState# + FPSfactor#
					ElseIf g\ShootState# > g\ShootSpeed-0.01
						HideEntity GunParticle
						If g\CurrAmmo > 0 Then g\CurrAmmo = g\CurrAmmo - 1
						g\ShootAnim = 1
						g\ShootState# = 0.0
					EndIf
				EndIf
			EndIf
		Else
			HideEntity g\ViewModel
			g\Deployed=0
			g\ShootState# = 0.0
			g\ReloadState# = 0.0
			g\ShootAnim = 0
			SetAnimTime(g\ViewModel, 0)
		EndIf
	Next
End Function

Global CurrentFOV# = 70

Function AnimateGuns()
	Local g.Guns
	
	If EqquipedGun <> Null Then
		PositionEntity GunPivot, EntityX(Camera), EntityY(Camera), EntityZ(Camera)
		MoveEntity GunPivot, (-Sin(Shake/2)*2.5)*0.0012, (Cos(MilliSecs()*0.05)*0.003),0
		GET_ANGLE% = False
		If GetAngleMax(EntityPitch(Camera), EntityPitch(GunPivot)) >= MAX_ANGLE_LIMIT Then
			RotateEntity(GunPivot, wrapangle(EntityPitch(Camera)-MAX_ANGLE_LIMIT), EntityYaw(GunPivot), 0)
			GET_ANGLE = True
		EndIf
		If GetAngleMax(EntityPitch(Camera), EntityPitch(GunPivot)) <= -MAX_ANGLE_LIMIT Then
			RotateEntity(GunPivot, wrapangle(EntityPitch(Camera)+MAX_ANGLE_LIMIT), EntityYaw(GunPivot), 0)
			GET_ANGLE = True
		EndIf
		
		If GetAngleMax(EntityYaw(Camera), EntityYaw(GunPivot)) >= MAX_ANGLE_LIMIT Then
			RotateEntity(GunPivot, EntityPitch(GunPivot), wrapangle(EntityYaw(Camera)-MAX_ANGLE_LIMIT), 0)
			GET_ANGLE = True
		EndIf
		If GetAngleMax(EntityYaw(Camera), EntityYaw(GunPivot)) <= -MAX_ANGLE_LIMIT Then
			RotateEntity(GunPivot, EntityPitch(GunPivot), wrapangle(EntityYaw(Camera)+MAX_ANGLE_LIMIT), 0)
			GET_ANGLE = True
		EndIf
		
		If HoldingGun > 0 Then
			MoveEntity GunPivot, EqquipedGun\CurrentSightMove, 0, 0
			If EqquipedGun\SightState = 1 And EqquipedGun\ReloadState# = 0.0 Then
				EqquipedGun\CurrentSightMove = CurveValue(EqquipedGun\SightRate, EqquipedGun\CurrentSightMove, 10)
				CurrentFOV = CurveValue(60, CurrentFOV, 5)
			Else
				EqquipedGun\CurrentSightMove = CurveValue(0.0, EqquipedGun\CurrentSightMove, 10)
				CurrentFOV = CurveValue(70, CurrentFOV, 5)
			EndIf
			EqquipedGun\SightState = MouseDown(2)*CanInteract()
		EndIf
		
	EndIf
End Function

Function CanInteract()
	Return (((Not MenuOpen) And (Not InvOpen) And (OtherOpen=Null) And (SelectedDoor = Null) And (ConsoleOpen = False) And (Using294 = False) And (SelectedScreen = Null) And EndingTimer=>0))
End Function

Function PlayGunSound(sound)
	If EqquipedGun\ChannelGun <> 0 Then StopChannel(EqquipedGun\ChannelGun) : EqquipedGun\ChannelGun = 0
	EqquipedGun\ChannelGun = PlaySound_Strict(sound)
End Function
Function IsAGun(tempname$)
	Select Lower(tempname)
		Case "usp"
			Return GUN_USP
		Case "p90"
			Return GUN_P90
		Case "mp5"
			Return GUN_MP5
		Case "ak"
			Return GUN_AK
		Case "m249"
			Return GUN_M249
		Case "pg"
			Return GUN_PG
	End Select
	Return 0
End Function
Function GetGunType.Guns(ID)
	For g.guns = Each Guns
		If g\ID = ID Then Return g
	Next
End Function
Function PickupGun(it.Items)
	If EqquipedGun = Null Then
		HoldingGun = IsAGun(it\itemtemplate\tempname)
		If HoldingGun <> 0 Then EqquipedGun = GetGunType(HoldingGun)
	ElseIf IsAGun(it\itemtemplate\tempname) Then
		If IsAGun(it\itemtemplate\tempname) = EqquipedGun\ID Then 
			EqquipedGun = Null
		Else
			HoldingGun = IsAGun(it\itemtemplate\tempname)
			If HoldingGun <> 0 Then EqquipedGun = GetGunType(HoldingGun)
		EndIf
	EndIf
End Function


Function IsGunSighting%()
	If EqquipedGun <> Null Then Return EqquipedGun\SightState
End Function
;~IDEal Editor Parameters:
;~C#Blitz3D