Create table ThreadComments(ID int,
createdBy nvarchar(max),createdOn datetime,updatedBy nvarchar(100),updatedOn datetime,status nvarchar(1),Thread_ID int
primary key(ID)
Foreign key(Thread_ID) references dbo.Thread(ID)
)

CREATE TABLE [dbo].[ThreadDiscussion](
	[ID] [int] NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Subject] [nvarchar](max) NULL,
	[Message] [nvarchar](max) NULL,
	[Attachments] [varbinary](max) NULL,
	[createdBy] [nvarchar](max) NULL,
	[createdOn] [datetime] NULL,
	[updatedBy] [nvarchar](100) NULL,
	[updatedOn] [datetime] NULL,
	[status] [nvarchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

insert into thread_discussion_entity values(1,'Theja',GetDate(),'test message','What is software','test subject','Theja',GETDATE())