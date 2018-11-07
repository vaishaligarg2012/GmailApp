
<link href="css/design.css" rel="stylesheet" id="bootstrap-css">
<%@include file="Header.jsp"%>

<div class="container">
	<div class="row"></div>
	<hr />
	<div class="row">
		<div class="col-sm-3 col-md-2">
					
				<a href="/GMail/composeMail.jsp"
					class="btn btn-danger btn-sm btn-block" role="button">COMPOSE</a>
				<hr />
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="AllMails"><span
							class="badge pull-right"></span> Inbox </a></li>
					
					<li><a  href="SentMailController" class="btn btn-primary active" style="width: 100%;text-align:left">Sent Mail</a>
					</li>

				</ul>
				</div>
		<div class="col-sm-9 col-md-10">

			<div class="tab-content"> New Message
				<div class="panel panel-default">
					<div class="panel-body">
					<form action="composeController" method="post">
						<div class="form-group">
							<label for="To">To</label> <input type="email"
								class="form-control" name ="to" id="to">

						</div>
						<div class="form-group">
							<label for="cc">CC</label> <input type="text"
								class="form-control" name ="cc" id="cc">
						</div>
						<div class="form-group">
							<label for="subject">Subject</label> <input type="text"
								class="form-control" name="subject" id="subject">
						</div>
						<div class="form-group">
							<label for="msg">Message</label> 
						    <textarea style="" class="form-control" rows="7" name ="msg" id="msg"></textarea>
								
						</div>
							<button type="submit" class="btn btn-default">Send</button>
</form>
					</div>
             

				</div>


			</div>
			
		</div>
	</div>
</div>
