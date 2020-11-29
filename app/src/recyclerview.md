1. 视窗模式
在ListView中，建议使用取景器模式，但这绝不是一种强迫。如果是RecyclerView，则必须使用RecyclerView.ViewHolder类。这是ListView和RecyclerView之间的主要区别之一。
它使RecyclerView中的事情更加复杂，但是我们在ListView中遇到的许多问题都得到了有效的解决。
2. 布局经理
这是对RecyclerView的另一个巨大增强。在ListView中，唯一可用的视图类型是垂直ListView。甚至没有正式的方法来实现水平ListView。
现在使用RecyclerView，我们可以
   - LinearLayoutManager—支持垂直和水平列表，
   - StaggeredLayoutManager—支持类似Pinterest的交错列表，
   - GridLayoutManager—支持在画廊应用程序中显示网格。
  最好的是，我们可以根据需要动态地完成所有这些工作。
3. 项目动画师
  ListView缺乏对良好动画的支持，但RecyclerView为它带来了一个全新的维度。使用RecyclerView.ItemAnimator类，设置视图动画变得非常简单和直观。
4. 项目装修
  对于ListView，动态地装饰项目（如添加边框或分隔符）绝非易事。但是，对于RecyclerView，类会给开发人员很大的控制权，但会使事情变得更加耗时和复杂。
5. OnitemTouchListener
  由于它的RecyclerView.ItemDecorator界面，截取列表视图上的项目单击非常简单。但是，recyclerview通过AdapterView.OnItemClickListener为开发人员提供了更多的功能和控制，但这对开发人员来说有点复杂。
  缺点
   - 它比列表视图复杂得多。
   - 初学者要花很多时间才能完全理解RecyclerView。
   - 它可能不必要地使您的编码生活困难。
   - 您需要花费比ListView所需的更多的时间来使用它。
