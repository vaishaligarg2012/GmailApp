<%@page import="java.util.List,com.Cmail.Model.ComposeMail"%>
<link href="css/design.css" rel="stylesheet" id="bootstrap-css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="Header.jsp"%>

<div class="container" >
	<div class="row">
		<div>${str}</div>

	</div>
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
			<!-- Nav tabs -->

			<ul class="nav nav-tabs">
				<li class="active"><a href="" data-toggle="tab"><span
						class="glyphicon glyphicon-inbox"> </span>View Message</a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<div class="tab-pane fade in active" id="home">
                 <c:forEach items="${detailsMails}" var="pObj">
                 
					<div class="list-group" style="margin-bottom:0px"><br/>
						<span class="name" style="min-width: 120px; display: inline-block;"><b>${pObj.to}</b><br/>
								</span><br/> <span class="">${pObj.subject}</span><br/>
								<span class="">${pObj.msg}</span>
								
					</div>
				</c:forEach>
					
				</div>

			</div>
		</div>
	</div>
</div>
