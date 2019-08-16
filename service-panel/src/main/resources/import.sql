USE [db_service_panel]

SET IDENTITY_INSERT [dbo].[pagina] ON 
INSERT [dbo].[pagina] ([pagina_id], [color], [titulo_color], [titulo_texto]) VALUES (1,'FFFFFF', '004885', 'PORTAFOLIO DE SERVICIOS')
SET IDENTITY_INSERT [dbo].[pagina] OFF

SET IDENTITY_INSERT [dbo].[footer] ON 
INSERT [dbo].[footer] ([footer_id], [color], [logo], [descripcion], [color_descripcion]) VALUES (1, 'A4B5C4', 'ruta', 'EXACT- Todos los derechos reservados', 'FFFFFF')
SET IDENTITY_INSERT [dbo].[footer] OFF

SET IDENTITY_INSERT [dbo].[tipo_item] ON 
INSERT [dbo].[tipo_item] ([tipo_item_id], [nombre]) VALUES (1, 'ITEM SISTEMA')
SET IDENTITY_INSERT [dbo].[tipo_item] OFF

SET IDENTITY_INSERT [dbo].[item] ON
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [color], [link_ruta]) VALUES (1, 'SIMIH', 'Sistema de Mensajería In House','RUTA' ,'EXACT- Todos los derechos reservados','FFFFFF', 'RUTA')
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [color], [link_ruta]) VALUES (1, 'EXTERNUS', 'Sistema de expedición externa','RUTA' ,'EXACT- Todos los derechos reservados', 'FFFFFF', 'RUTA')
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [color], [link_ruta]) VALUES (1, 'RVA', 'Sistema de recogo de valijas en agencias','RUTA','EXACT- Todos los derechos reservados','FFFFFF', 'RUTA')
SET IDENTITY_INSERT [dbo].[item] OFF
