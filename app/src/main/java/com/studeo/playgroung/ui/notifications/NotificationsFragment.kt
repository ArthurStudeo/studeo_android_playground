package com.studeo.playgroung.ui.notifications


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.studeo.staging.playgroung.R
import com.studeo.staging.playgroung.databinding.FragmentNotificationsBinding


class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var mWebView: WebView? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        mWebView = root.findViewById<View>(R.id.webview) as WebView
        mWebView!!.webViewClient = MyWebViewClient()
        //mWebView!!.loadUrl("http://10.0.2.2:3010/flashcard-standalone/123?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyNjE5NSwiaWF0IjoxNjk0Njc0MjMwfQ.Kayrb7ubIhZwM5NeusXtMo01z_TCtdiiM-uKZDD_WH4")
        mWebView!!.loadUrl("http://10.0.2.2:3010/game-standalone?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjozMDE5OCwiaWF0IjoxNjk2MjM0NjA4fQ.Suz1p1V9VL_0slI-6CdlsWp0vliK8agfx8jWdRLWF1A")
        mWebView!!.loadUrl("https://solver.staging.studeo.group/game-standalone?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjozMDE5OCwiaWF0IjoxNjk2MjM0NjA4fQ.Suz1p1V9VL_0slI-6CdlsWp0vliK8agfx8jWdRLWF1A")

        //mWebView!!.loadUrl("http://10.0.2.2:3010")
        //mWebView!!.loadUrl("https://0138-2001-861-8c98-de10-ac42-f79e-21d8-b481.ngrok-free.app/flashcard-standalone/123?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyNjE5NSwiaWF0IjoxNjk0Njc0MjMwfQ.Kayrb7ubIhZwM5NeusXtMo01z_TCtdiiM-uKZDD_WH4")
        //mWebView!!.loadUrl("https://solver.staging.studeo.group/flashcard-standalone/123?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjozMDMzNSwiaWF0IjoxNjk0NTkzNzAxfQ.lg5FBJbHutXtkEyd6UTUjTF3F_LG-_pqt8gqdgqoBzY");
        //mWebView!!.loadUrl("https://google.com")

        // Enable Javascript

        // Enable Javascript
        val webSettings: WebSettings = mWebView!!.getSettings()
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true;
        mWebView!!.clearView();
        mWebView!!.measure(100, 100);
        webSettings.useWideViewPort = true;
        webSettings.loadWithOverviewMode = true;

        // Force links and redirects to open in the WebView instead of in a browser

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView!!.webViewClient = WebViewClient()



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}