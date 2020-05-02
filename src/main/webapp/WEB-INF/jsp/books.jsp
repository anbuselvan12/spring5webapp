<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<table class="table table-striped">
			<caption>Your books are</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>ISBN</th>
					<th>Publisher</th>
					<th>Amount</th>
					<th>Date</th>
					<th>Update</th>
					<th>Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td>${book.id}</td>
						<td>${book.title}</td>
						<td>${book.isbn}</td>
						<td>${book.publisher}</td>
						<td>${book.amount}</td>
						<td><fmt:formatDate value="${book.date}" pattern="dd/MM/yyyy"/></td>
						<td><a type="button" class="btn btn-warning" 
		href="/update-book?id=${book.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" 
		href="/delete-book?id=${book.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div> <a class="button" href="/add-to-book">Add a book</a> </div>
	
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
<%@ include file="common/footer.jspf" %>