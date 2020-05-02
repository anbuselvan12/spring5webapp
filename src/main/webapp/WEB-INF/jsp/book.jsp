<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<form:form method="post" modelAttribute="bookInfo">
		<form:hidden path="id"/>  
			<fieldset class="form-group">
				<form:label path="title">Title</form:label> 
				<form:input path="title" type="text" class="form-control" required="required"/> 
				<form:errors path="title" cssClass="text-warning"/>
				
				
			</fieldset>
			<fieldset class="form-group">
			    <form:label path="isbn">ISBN</form:label> 
				<form:input path="isbn" type="text" class="form-control" required="required"/> 
				<form:errors path="isbn" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="publisher">Publisher</form:label> 
				<form:input path="publisher" type="text" class="form-control" required="required"/> 
				<form:errors path="publisher" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="amount">Amount</form:label> 
				<form:input path="amount" type="text" class="form-control" /> 
			</fieldset>
			
				
			
			<fieldset class="form-group">
				<form:label path="date">Target Date</form:label>
				<form:input path="date" type="text" class="form-control"
					required="required" />
				<form:errors path="date" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
			
		

			
		
		</form:form>
	</div>

	<%@ include file="common/footer.jspf" %>
</body>

</html>
