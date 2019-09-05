USE [db_service_panel]

SET IDENTITY_INSERT [dbo].[pagina] ON 
INSERT [dbo].[pagina] ([pagina_id], [color],[descripcioncolor]) VALUES (1,'#FFFFFF','#606362')
SET IDENTITY_INSERT [dbo].[pagina] OFF

SET IDENTITY_INSERT [dbo].[footer] ON 
INSERT [dbo].[footer] ([footer_id], [color], [logo], [descripcion], [color_descripcion]) VALUES (1, '#92999f', 'C:\Panel\logos\exact.png', 'EXACT- Todos los derechos reservados', '#FFFFFF')
SET IDENTITY_INSERT [dbo].[footer] OFF

SET IDENTITY_INSERT [dbo].[tipo_item] ON 
INSERT [dbo].[tipo_item] ([tipo_item_id], [nombre]) VALUES (1, 'ITEM SISTEMA')
SET IDENTITY_INSERT [dbo].[tipo_item] OFF

SET IDENTITY_INSERT [dbo].[item] ON
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [link_ruta],[tipo_item_id],[activo],[video]) VALUES (1, 'SIMIH', 'Sistema de gestión y control del flujo de documentos que garantiza la disponibilidad, seguridad e integridad de la información','C:\Panel\logos\simih.png' ,1, 'http://exact.com.pe/simih-demo-v2/paginas/pagina.html#/Login',1,1,'https://www.youtube.com/embed/6h2Et87EomY')
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [link_ruta],[tipo_item_id],[activo],[video]) VALUES (2, 'EXTERNUS', 'Sistema de control de envío de documentos externos que garantiza la disponibilidad en tiempo real de la información del estado documental, además del monitoreo de su flujo.','C:\Panel\logos\externus.png' ,2, 'http://www.exact.com.pe/',1,1,'https://www.youtube.com/embed/6h2Et87EomY')
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [link_ruta],[tipo_item_id],[activo],[video]) VALUES (3, 'RVA', 'Sistema de control de valijas de agencia que garantiza la disponibilidad en tiempo real de la información del estado de las valijas, además del monitoreo del flujo de éstas','C:\Panel\logos\rva.png',3, 'http://exact.com.pe:8087/login/',1,1,'https://www.youtube.com/embed/6h2Et87EomY')
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [link_ruta],[tipo_item_id],[activo],[video]) VALUES (4, 'ENVI', 'Lorem ipsum dolor sit amet consectetur adipiscing elit pharetra himenaeos','C:\Panel\logos\envi.png' ,4, 'http://www.exact.com.pe/',1,1,'https://www.youtube.com/embed/6h2Et87EomY')
INSERT [dbo].[item] ([item_id], [nombre], [descripcion], [ruta_imagen], [orden], [link_ruta],[tipo_item_id],[activo],[video]) VALUES (5, 'EWAREHOUSE', 'Lorem ipsum dolor sit amet consectetur adipiscing elit pharetra himenaeos, sapien dictumst dis blandit turpis ornare eu euismod a','C:\Panel\logos\ewarehouse.png',5, 'http://www.exact.com.pe/',1,1,'https://www.youtube.com/embed/6h2Et87EomY')
SET IDENTITY_INSERT [dbo].[item] OFF

SET IDENTITY_INSERT [dbo].[titulo] ON 
INSERT [dbo].[titulo] ([titulo_id], [texto],[color_alto],[color_medio],[color_bajo],[opacidad]) VALUES (1, 'NUESTRO PORTAFOLIO', '#004885', '#004885', '#269FC0', '#B4D7EB')
INSERT [dbo].[titulo] ([titulo_id], [texto],[color_alto],[color_medio],[color_bajo],[opacidad]) VALUES (2, 'DE SERVICIOS', '#004885', '#004885', '#269FC0', '#B4D7EB')
SET IDENTITY_INSERT [dbo].[titulo] OFF
