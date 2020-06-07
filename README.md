# About
innosoft-tooltip aims to help produce an easily usable implementation of tooltip.<br/>
<br/>
<br/>
[![](https://jitpack.io/v/maedilaziman/innosoft-tooltip.svg)](https://jitpack.io/#maedilaziman/innosoft-tooltip)
</br>
<br/>
<h2>Dependency</h2>
Add this in your root build.gradle file (not your module build.gradle file):
<br/>
<br/>
<pre><span class="pl-en">allprojects</span> {
	repositories {
        maven { url <span class="pl-s"><span class="pl-pds">"</span>https://jitpack.io<span class="pl-pds">"</span></span> }
    }
}</pre>
Then, add the library to your module build.gradle
<br/>
<br/>
<pre><span class="pl-en">dependencies</span> {
    implementation <span class="pl-s"><span class="pl-pds">'</span>com.github.maedilaziman:innosoft-tooltip:1.0.0<span class="pl-pds">'</span></span>
}</pre>
Release 1.0.1
</br>
</br>
<pre><span class="pl-en">dependencies</span> {
    implementation <span class="pl-s"><span class="pl-pds">'</span>com.github.maedilaziman:innosoft-tooltip:1.0.1<span class="pl-pds">'</span></span>
}</pre>
<h2>Features</h2>
<ul>
<li>Create beauty tooltip</li>
</ul>
<h2>Features release 1.0.1</h2>
Change tooltip design
<br/>
<h2>Usage</h2>
example tooltip with style fill background color and arrow direction on bottom
<br/>
<br/>
<pre>&lt;com.maedi.soft.ino.tooltip.view.Tooltip<br />    android:id="@+id/tooltip1"<br />    android:layout_width="match_parent"<br />    android:layout_height="100dp"<br />    android:layout_marginLeft="20dp"<br />    android:layout_marginRight="20dp"<br />    app:tooltip_backgroundColor="@color/em_black_87"<br />    app:tooltip_cornerRadius="30"<br />    app:tooltip_arrowDirection="bottom"<br />    app:tooltip_arrowHeight="60"<br />    app:tooltip_arrowWidth="60"<br />    app:tooltip_arrowPosition="200"<br />    app:tooltip_gravity="top"<br />    app:tooltip_style="fill"<br />    android:orientation="horizontal"&gt;<br /><br />    &lt;TextView<br />        android:layout_width="wrap_content"<br />        android:layout_height="wrap_content"<br />        android:text="Hi.."<br />        android:textColor="@color/white"/&gt;<br /><br />&lt;/com.maedi.soft.ino.tooltip.view.Tooltip&gt;</pre>
<br/>
example tooltip with border color style, and arrow direction on top
<br/>
<br/>
<pre>&lt;com.maedi.soft.ino.tooltip.view.Tooltip<br />    android:id="@+id/tooltip2"<br />    android:layout_width="match_parent"<br />    android:layout_height="100dp"<br />    android:layout_marginLeft="20dp"<br />    android:layout_marginRight="20dp"<br />    app:tooltip_backgroundColor="@color/em_black_87"<br />    app:tooltip_cornerRadius="30"<br />    app:tooltip_arrowDirection="top"<br />    app:tooltip_arrowHeight="60"<br />    app:tooltip_arrowWidth="60"<br />    app:tooltip_arrowPosition="200"<br />    app:tooltip_gravity="center"<br />    app:tooltip_style="border"<br />    android:orientation="horizontal"&gt;<br /><br />    &lt;TextView<br />        android:layout_width="wrap_content"<br />        android:layout_height="wrap_content"<br />        android:text="Hi.."<br />        android:textColor="@color/em_black_100"/&gt;<br /><br />&lt;/com.maedi.soft.ino.tooltip.view.Tooltip&gt;</pre>
<br/>
show tooltip with animation
<br/>
<br/>
<pre>tooltip1.showViewWithAnim(tooltip1);</pre>
<br/>
hide tooltip with animation
<br/>
<br/>
<pre>tooltip1.hideViewWithAnim(tooltip1);</pre>
<br/>
That's it!
<br/>
<h2>License</h2>
<pre><code>Copyright 2020 Maedi Laziman
<br/>
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
<br/>
   http://www.apache.org/licenses/LICENSE-2.0
<br/>
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.</code></pre>
