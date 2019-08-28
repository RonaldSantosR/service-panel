USE [db_service_panel]

SET IDENTITY_INSERT [dbo].[pagina] ON 
INSERT [dbo].[pagina] ([pagina_id], [color]) VALUES (1,'#FFFFFF')
SET IDENTITY_INSERT [dbo].[pagina] OFF

SET IDENTITY_INSERT [dbo].[footer] ON 
INSERT [dbo].[footer] ([footer_id], [color], [logo], [descripcion], [color_descripcion]) VALUES (1, '#92999f', 'C:/Panel/logos/exact.png', 'EXACT- Todos los derechos reservados', '#FFFFFF')
SET IDENTITY_INSERT [dbo].[footer] OFF

SET IDENTITY_INSERT [dbo].[tipo_item] ON 
INSERT [dbo].[tipo_item] ([tipo_item_id], [nombre]) VALUES (1, 'ITEM SISTEMA')
SET IDENTITY_INSERT [dbo].[tipo_item] OFF

SET IDENTITY_INSERT [dbo].[item] ON
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [color_texto], [link_ruta],[tipo_item_id]) VALUES (1, 'SIMIH', 'Sistema de Mensajería In House','C:/Panel/logos/simih.png' ,1,'#269FC0', 'http://www.exact.com.pe/',1)
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [color_texto], [link_ruta],[tipo_item_id]) VALUES (2, 'EXTERNUS', 'Sistema de expedición externa','C:/Panel/logos/externus.png' ,2, '#269FC0', 'http://www.exact.com.pe/',1)
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [color_texto], [link_ruta],[tipo_item_id]) VALUES (3, 'RVA', 'Sistema de recogo de valijas en agencias','C:/Panel/logos/rva.png',3,'#269FC0', 'http://www.exact.com.pe/',1)
SET IDENTITY_INSERT [dbo].[item] OFF

SET IDENTITY_INSERT [dbo].[titulo] ON 
INSERT [dbo].[titulo] ([titulo_id], [texto],[color_alto],[color_medio],[color_bajo],[opacidad]) VALUES (1, 'NUESTRO PORTAFOLIO', '#004885', '#004885', '#269FC0', '#B4D7EB')
INSERT [dbo].[titulo] ([titulo_id], [texto],[color_alto],[color_medio],[color_bajo],[opacidad]) VALUES (2, 'DE SERVICIOS', '#004885', '#004885', '#269FC0', '#B4D7EB')
SET IDENTITY_INSERT [dbo].[titulo] OFF
